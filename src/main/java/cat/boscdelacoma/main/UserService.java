package cat.boscdelacoma.main;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password));
        return true;
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.login(password);
    }
}
