package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Reviews")
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private int score;
    private String comment;
    @Temporal(TemporalType.DATE)
    private Date createAt;
    @Temporal(TemporalType.DATE)
    private Date upatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Game game;

    public Review(int score, String comment, Date createAt, Date upatedAt) {
        this.score = score;
        this.comment = comment;
        this.createAt = createAt;
        this.upatedAt = upatedAt;
    }
}
