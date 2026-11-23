package ABB.Tech.Class2.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "passports")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true, length = 20)
    private String serialNumber;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "country", nullable = false  , length = 100)
    private String country;


    @OneToOne(optional = false)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false, unique = true)
    private User user;
}
