package DAO;

import appUtil.AppUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.neo4j.driver.Driver;
import org.neo4j.driver.SessionConfig;

public class GenreDao {
    private static final Gson GSON = new GsonBuilder().create();
    private static Driver driver;
    private SessionConfig sessionConfig;



    public GenreDao(Driver driver, String dbName) {
        this.driver = AppUtil.initDriver();
        sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
    }


    public void close() {
        driver.close();
    }
    //Tim kiem album thuoc ve the loai nao do khi biet ten the loai

}
