package org.example;

import models.Game;
import models.Review;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Game game = new Game("Warzone", "Shooter", "PC", 60, Date.from(Instant.now()),Date.from(Instant.now()));
        Review review = new Review(5, "bang bang", Date.from(Instant.now()),Date.from(Instant.now()));

        List<Review> reviews  = new ArrayList<>();
        reviews.add(review);

        game.setReviews(reviews);
        review.setGame(game);

        entityManager.persist(game);
        entityManager.persist(review);

        transaction.commit();

// close entity manager
        entityManager.close();
        entityManagerFactory.close();
        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}