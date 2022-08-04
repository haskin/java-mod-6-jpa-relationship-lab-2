package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Games")
@Getter
@Setter
@NoArgsConstructor
public class Game {
    @Id
            @GeneratedValue(generator = "UUID")
            @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    String id;
    private String title;
    private String genre;
    private String platform;
    private int price;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @OneToMany(mappedBy = "game")
    private List<Review> reviews = new ArrayList<>();

    public Game(String title, String genre, String platform, int price, Date createdAt, Date updatedAt ) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
