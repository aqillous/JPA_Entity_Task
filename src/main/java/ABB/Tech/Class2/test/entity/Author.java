package ABB.Tech.Class2.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false , length = 50)
    private String name;

    @Column(name = "surname", nullable = false , length = 50)
    private String surname;

    @Column(name = "country", nullable = false , length = 50)
    private String country;

    @OneToMany(
            mappedBy = "author",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<AuthorBook> authorBooks;

}
