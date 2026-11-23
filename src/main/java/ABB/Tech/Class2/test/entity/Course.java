package ABB.Tech.Class2.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false , unique = true ,  length = 100)
    private String title;

    @Column(name = "credit", nullable = false)
    private Integer credit;

    @Column(name = "teacher", nullable = false , length = 100)
    private String teacher;

    @ManyToMany(
            mappedBy = "courses",
            fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();


}
