package TestDao;

import DAO.AlbumDao;
import DAO.ArtistDao;
import appUtil.AppUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDaoAlbum {
    public static String DB_NAME = "music";
    private AlbumDao albumDao;
    @BeforeAll
    public void setUp() {
        albumDao = new AlbumDao(AppUtil.initDriver(), DB_NAME);
    }
    @Test
    public void testUpdatePriceAlbum() {
        albumDao.updatePrice("A001", 1000);
        System.out.println("Cập nhật thành công");
    }
    //Tim kiem album thuoc ve the loai nao do khi biet ten the loai
    @Test
    public void testFindAlbumByGenre() {
        albumDao.findAlbumByGenre("Pop").forEach(System.out::println);
    }
    //Thong ke so album theo tung the loai , ket qua sap xep theo the loai tang dan
    @Test
    public void getNumberOfAlbumByGenre() {
        albumDao.getNumberOfAlbumByGenre().forEach((k, v) -> System.out.println(k + " : " + v));
    }
    @AfterAll
    public void tearDown() {
        albumDao.close();
    }
}
