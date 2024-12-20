package geogame;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GeoGameTest {
    User user = new User();
    GeoGameMain geoMain = new GeoGameMain();

    @Test
    public void testGetFileName() {
        File file = new File("src/main/java/geogame/flagg/norway.png");
        
        assertEquals("norway", geoMain.riktigNavn(file));
    }

    @Test
    public void testInitialScore() {
        assertEquals(0, geoMain.getScore());
    }

    @Test
    public void testNegativeScore() {
        assertThrows(IllegalArgumentException.class, () -> {
            geoMain.setScore(-1);
        });
    }

    @Test
    public void testListe() {
        List<File> fileList = geoMain.liste();
        assertNotNull(fileList);
    }

    @Test
    public void testSetScore() {
        user.setScore(10);

        assertEquals(10, user.getScore());
    }

    @Test
    public void testSave() throws FileNotFoundException {
        
        user.save("test", 200);
        
        File savedFile = new File("src/main/java/geogame/saves/" + "test");
        assertTrue(savedFile.exists());
    }

    @Test
    public void testLoad() throws FileNotFoundException {

        user.load("test");

        assertEquals(200, user.getScore());
    }
}
