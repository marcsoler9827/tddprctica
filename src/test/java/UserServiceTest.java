package cat.boscdelacoma.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testRegisterAndLogin() {
        UserService userService = new UserService();


        assertTrue(userService.register("joan", "password123"));


        assertFalse(userService.register("joan", "password123"));


        assertTrue(userService.login("joan", "password123"));


        assertFalse(userService.login("joan", "wrongPassword"));
    }
}
