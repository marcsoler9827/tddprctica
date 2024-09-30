package cat.boscdelacoma.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewTest {

    @Test
    public void testAddReview() {
        Videogame game = new Videogame("Return to Monkey Island", "Point and click", "Windows", 22.99f);
        User user = new User("joan", "password123");
        Review review = new Review(user, "Amazing game!", 5);

        game.addReview(review);


        assertEquals(1, game.getReviews().size());
        assertEquals("Amazing game!", game.getReviews().get(0).getComment());
        assertEquals(5, game.getReviews().get(0).getRating());
    }
}
