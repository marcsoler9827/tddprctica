import cat.boscdelacoma.main.VideogamesLibrary;
import cat.boscdelacoma.main.User;
import cat.boscdelacoma.main.Videogame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VideogamesLibraryIntegrationTest {

    VideogamesLibrary library;

    @BeforeEach
    void setUp() {
        library = new VideogamesLibrary();
        library.addVideogame(new Videogame("Return to Monkey Island", "Point and click", "Windows", 22.99f));
    }

    @Test
    void testFullInteraction() {
        User joan = new User("Joan", "password123");
        Videogame videogame1 = library.find(joan, "Return to Monkey Island");

        User josep = new User("Josep", "password456");
        Videogame videogame2 = library.find(josep, "Return to Monkey Island");

        // Check that both users consulted the same game
        assertEquals(videogame1, videogame2);
        assertTrue(videogame1.getUsersWhoHaveConsulted().contains(joan));
        assertTrue(videogame2.getUsersWhoHaveConsulted().contains(josep));


        assertEquals(2, videogame1.getUsersWhoHaveConsulted().size());
    }
}
