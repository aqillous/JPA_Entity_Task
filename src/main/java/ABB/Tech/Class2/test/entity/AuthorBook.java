package ABB.Tech.Class2.test.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "author_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "author_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_ab_author")
    )
    private Author author;


    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "book_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_ab_book")
    )
    private Book book;

    //Why use an intermediate entity?
    //
    //Advantages:
    //- You can add additional fields such as author role, contribution, publication date, etc.
    //- You can manage the relationship independently.
    //- You can apply constraints and business logic to the relationship itself.
}
