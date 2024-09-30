package cat.boscdelacoma.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Videogame {
    private String name;
    private String genre;
    private String platforms;
    private float price;
    private Set<User> usersWhoHaveConsulted;
    private List<Review> reviews;

    // Constructor
    public Videogame(String name, String genre, String platforms, float price) {
        this.name = name;
        this.genre = genre;
        this.platforms = platforms;
        this.price = price;
        this.usersWhoHaveConsulted = new HashSet<>();
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public void addUsersWhoHaveConsulted(User user) {
        usersWhoHaveConsulted.add(user);
    }


    public Set<User> getUsersWhoHaveConsulted() {
        return usersWhoHaveConsulted;
    }


    public void addReview(Review review) {
        reviews.add(review);
    }


    public List<Review> getReviews() {
        return reviews;
    }


    public void showData() {
        System.out.println(name + " is a " + genre + " game available on " + platforms + " for " + price);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Videogame videogame = (Videogame) obj;
        return name.equals(videogame.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
