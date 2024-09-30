package cat.boscdelacoma.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class VideogameSearchTest {

    @Test
    public void testSearchByCategoryPlatformAndPrice() {
        VideogamesLibrary library = new VideogamesLibrary();
        library.addVideogame(new Videogame("Return to Monkey Island", "Point and click", "Windows", 22.99f));
        library.addVideogame(new Videogame("Hollow Knight", "Metroidvania", "Windows", 14.99f));
        library.addVideogame(new Videogame("Overwatch", "Shooter", "PlayStation", 39.99f));

        // Test category search
        List<Videogame> pointAndClickGames = library.searchByCategory("Point and click");
        assertEquals(1, pointAndClickGames.size());

        // Test platform search
        List<Videogame> windowsGames = library.searchByPlatform("Windows");
        assertEquals(2, windowsGames.size());

        // Test price range search
        List<Videogame> cheapGames = library.searchByPriceRange(10.0f, 20.0f);
        assertEquals(1, cheapGames.size());
    }
}
