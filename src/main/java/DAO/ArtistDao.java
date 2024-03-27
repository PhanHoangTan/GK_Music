package DAO;

import Entity.Artist;
import appUtil.AppUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.neo4j.driver.Driver;
import org.neo4j.driver.SessionConfig;

public class ArtistDao {
    private static final Gson GSON = new GsonBuilder().create();
    private static Driver driver;
    private SessionConfig sessionConfig;



    public ArtistDao(Driver driver, String dbName) {
        this.driver = AppUtil.initDriver();
        sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
    }


    public void close() {
        driver.close();
    }
    //1 Them mot artist moi "name='" + name + '\'' +
    //                ", id='" + id + '\'' +
    //                ", birthDate='" + birthDate + '\'' +
    //                ", url='" + url + '\'' +
    //trong neo4j
    public boolean addArtist(String name, String id, String birthDate, String url) {
        String query = "CREATE (artist:Artist {name: $name, id: $id, birthDate: $birthDate, url: $url})";
        try (org.neo4j.driver.Session session = driver.session(sessionConfig)) {
            session.writeTransaction(tx -> {
                tx.run(query, org.neo4j.driver.Values.parameters("name", name, "id", id, "birthDate", birthDate, "url", url));
                return null;
            });
        }
        return true;
    }


}
