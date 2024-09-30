package cat.boscdelacoma.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserRegistrationAndLogin() {
        User user = new User("joan", "password123");

        // Verifica que el registre ha estat correcte
        assertEquals("joan", user.getUsername());
        assertEquals("password123", user.getPassword());

        // Comprova login correcte
        assertTrue(user.login("password123"));

        // Comprova login incorrecte
        assertFalse(user.login("wrongPassword"));
    }
}
