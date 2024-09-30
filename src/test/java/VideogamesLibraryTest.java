import cat.boscdelacoma.main.VideogamesLibrary;
import cat.boscdelacoma.main.User;
import cat.boscdelacoma.main.Videogame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VideogamesLibraryTest {

    VideogamesLibrary library;

    @BeforeEach
    void setUp() {
        library = new VideogamesLibrary();
        library.addVideogame(new Videogame("Return to Monkey Island", "Point and click", "Windows", 22.99f));
    }

    @Test
    void testFindExistingVideogame() {
        User user = new User("Joan", "password123");
        Videogame videogame = library.find(user, "Return to Monkey Island");

        assertNotNull(videogame);
        assertEquals("Return to Monkey Island", videogame.getName());
    }

    @Test
    void testFindNonExistingVideogame() {
        User user = new User("Joan", "password123");
        Videogame videogame = library.find(user, "Nonexistent Game");

        assertNull(videogame);
    }

    @Test
    void testUserConsultationAddedToVideogame() {
        User user = new User("Josep", "password456");
        Videogame videogame = library.find(user, "Return to Monkey Island");

        assertNotNull(videogame);
        assertTrue(videogame.getUsersWhoHaveConsulted().contains(user));
    }
}
