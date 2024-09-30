package cat.boscdelacoma.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class VideogamesLibrary {
    private Map<String, Videogame> games;


    public VideogamesLibrary() {
        games = new HashMap<>();
    }


    public void addVideogame(Videogame videogame) {
        games.put(videogame.getName(), videogame);
    }


    public Videogame find(User user, String gameName) {
        Videogame game = games.get(gameName);
        if (game != null) {
            game.addUsersWhoHaveConsulted(user);
        }
        return game;
    }


    public List<Videogame> searchByCategory(String category) {
        List<Videogame> result = new ArrayList<>();
        for (Videogame game : games.values()) {
            if (game.getGenre().equalsIgnoreCase(category)) {
                result.add(game);
            }
        }
        return result;
    }

    public List<Videogame> searchByPlatform(String platform) {
        List<Videogame> result = new ArrayList<>();
        for (Videogame game : games.values()) {
            if (game.getPlatforms().equalsIgnoreCase(platform)) {
                result.add(game);
            }
        }
        return result;
    }

    public List<Videogame> searchByPriceRange(float minPrice, float maxPrice) {
        List<Videogame> result = new ArrayList<>();
        for (Videogame game : games.values()) {
            if (game.getPrice() >= minPrice && game.getPrice() <= maxPrice) {
                result.add(game);
            }
        }
        return result;
    }
}
