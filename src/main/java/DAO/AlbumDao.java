package DAO;

import Entity.Album;
import appUtil.AppUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlbumDao {

    private static final Gson GSON = new GsonBuilder().create();
    private static Driver driver;
    private SessionConfig sessionConfig;



    public AlbumDao(Driver driver, String dbName) {
        this.driver = AppUtil.initDriver();
        sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
    }


    public void close() {
        driver.close();
    }
    //Cap nhat don gia cho mot album nao do khi biet ma so album
    public boolean updatePrice(String albumID, double price) {
        String query = "MATCH (album:Album) WHERE toUpper(album.id) = $albumID SET album.price = $price";
        try (org.neo4j.driver.Session session = driver.session(sessionConfig)) {
            session.writeTransaction(tx -> {
                tx.run(query, org.neo4j.driver.Values.parameters("albumID", albumID, "price", price));
                return price;
            });
        }
        return true;
    }
    //Tim kiem album thuoc ve the loai nao do khi biet ten the loai
    public List<Album> findAlbumByGenre(String name) {
        String query = "MATCH (album:Album)-[:BELONG_TO]->(genre:Genre) WHERE genre.name = $name RETURN album";
        Map<String, Object> map = Map.of("name", name);
        try(Session session = driver.session(sessionConfig)) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, map);
                if (!result.hasNext()) {
                    return null;
                }
                return result.stream().map(record -> {
                    Node node = record.get("album").asNode();
                    return AppUtil.convert(node, Album.class);
                }).toList();
            });

        }
    }
    //Thong ke so album theo tung the loai , ket qua sap xep theo the loai tang dan
    public Map<String,Long> getNumberOfAlbumByGenre() {
        String query = "MATCH (album:Album)-[:BELONG_TO]->(genre:Genre) RETURN genre.name as genre, count(album) as count ORDER BY genre";
        try (Session session = driver.session(sessionConfig)) {
            return session.executeRead(tx -> {
                Result result = tx.run(query);
                if (!result.hasNext()) {
                    return null;
                }
//                return result.stream().collect(Collectors.toMap(record -> record.get("genre").asString(), record -> record.get("count").asLong())),
//                (a, b) -> a, LinkedHashMap::new);
                return result.stream().collect(Collectors.toMap(record -> record.get("genre").asString(), record -> record.get("count").asLong(),
                        (a, b) -> a,
                        LinkedHashMap::new));

            });

        }
    }}