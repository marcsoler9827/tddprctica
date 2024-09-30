import cat.boscdelacoma.main.Videogame;
import cat.boscdelacoma.main.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VideogameTest {

    Videogame videogame;

    @BeforeEach
    void setUp() {
        videogame = new Videogame("Return to Monkey Island", "Point and click", "Windows", 22.99f);
    }

    @Test
    void testGetName() {
        assertEquals("Return to Monkey Island", videogame.getName());
    }


}
