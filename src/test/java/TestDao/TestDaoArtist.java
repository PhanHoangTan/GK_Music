package TestDao;

import DAO.ArtistDao;
import appUtil.AppUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDaoArtist {
public static String DB_NAME = "music";
    private ArtistDao artistDao;
    @BeforeAll
    public void setUp() {
        artistDao = new ArtistDao(AppUtil.initDriver(), DB_NAME);
    }
@Test
  public void testAddArtist() {
        artistDao.addArtist("A00tt", "A004", "UK", "1999-01-01");
        System.out.println("Thêm thành công");

    }

    @AfterAll

    public void tearDown() {
        artistDao.close();
    }

}
