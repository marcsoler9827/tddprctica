package cat.boscdelacoma.main;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        VideogamesLibrary library = new VideogamesLibrary();
        library.addVideogame(new Videogame("Return to Monkey Island", "Point and click", "Windows", 22.99f));
        library.addVideogame(new Videogame("FIFA 23", "Sports", "PS5", 59.99f));
        library.addVideogame(new Videogame("Overwatch", "Shooter", "PlayStation", 39.99f));

        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Register user");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        boolean registered = userService.register(username, password);
        if (!registered) {
            System.out.println("Username already taken.");
        }

        System.out.println("Login");
        System.out.print("Username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Password: ");
        String loginPassword = scanner.nextLine();
        boolean loggedIn = userService.login(loginUsername, loginPassword);
        if (!loggedIn) {
            System.out.println("Invalid credentials.");
            return;
        }
        User currentUser = new User(loginUsername, loginPassword);

        System.out.println("Search for games by category");
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        List<Videogame> gamesByCategory = library.searchByCategory(category);
        gamesByCategory.forEach(Videogame::showData);

        System.out.println("Search for games by platform");
        System.out.print("Enter platform: ");
        String platform = scanner.nextLine();
        List<Videogame> gamesByPlatform = library.searchByPlatform(platform);
        gamesByPlatform.forEach(Videogame::showData);

        System.out.println("Search for games by price range");
        System.out.print("Enter minimum price: ");
        float minPrice = scanner.nextFloat();
        System.out.print("Enter maximum price: ");
        float maxPrice = scanner.nextFloat();
        List<Videogame> gamesByPrice = library.searchByPriceRange(minPrice, maxPrice);
        gamesByPrice.forEach(Videogame::showData);

        scanner.nextLine(); // Clear input buffer

        System.out.println("Review a game");
        System.out.print("Enter game name: ");
        String gameName = scanner.nextLine();
        Videogame gameToReview = library.find(currentUser, gameName);
        if (gameToReview != null) {
            System.out.print("Enter your comment: ");
            String comment = scanner.nextLine();
            System.out.print("Enter your rating (1-5): ");
            int rating = scanner.nextInt();
            gameToReview.addReview(new Review(currentUser, comment, rating));
        }

        System.out.println("\n** USERS WHO HAVE CONSULTED 'Return to Monkey Island'");
        Videogame consultedGame = library.find(currentUser, "Return to Monkey Island");
        Set<User> usersWhoHaveConsulted = consultedGame.getUsersWhoHaveConsulted();
        for (User user : usersWhoHaveConsulted) {
            System.out.println(user.getUsername());
        }
        
        System.out.println("\n** REVIEWS FOR 'Return to Monkey Island'");
        List<Review> reviews = consultedGame.getReviews();
        for (Review review : reviews) {
            System.out.println(review.getUser().getUsername() + ": " + review.getComment() + " (Rating: " + review.getRating() + ")");
        }
    }
}