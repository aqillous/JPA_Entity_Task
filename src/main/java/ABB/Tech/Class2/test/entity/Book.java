package ABB.Tech.Class2.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;


import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Check(name = "chk_book_price" , constraints = "price > 0")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false , unique = true ,  length = 100)
    private String title;

    @Column(name = "price", nullable = false, precision = 8 , scale = 2)
    private BigDecimal price;

    @Column(name = "page_count", nullable = false)
    private Integer pageCount;

    @OneToMany(
            mappedBy = "book",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<AuthorBook> authorBooks;
}
