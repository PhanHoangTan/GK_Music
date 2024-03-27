package TestDao;

import DAO.GenreDao;
import appUtil.AppUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDaoGenre {
    public static String DB_NAME = "music";
    private GenreDao genreDao;
    @BeforeAll
    public void setUp() {
        genreDao = new GenreDao(AppUtil.initDriver(), DB_NAME);
    }
    @Test
    //Tim kiem album thuoc ve the loai nao do khi biet ten the loai

    @AfterAll
    public void tearDown() {
        genreDao.close();
    }
}
