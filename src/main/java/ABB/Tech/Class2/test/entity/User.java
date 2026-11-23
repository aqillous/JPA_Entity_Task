package ABB.Tech.Class2.test.entity;

import ABB.Tech.Class2.test.converter.GenderConverter;
import ABB.Tech.Class2.test.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false , length = 100)
    private String name;

    @Column(name = "surname" , nullable = false , length = 100)
    private String surname;

    @Column(name = "email" , nullable = false , length = 100 ,unique = true)
    private String email;

    @Column(name = "gender_id" , nullable = false)
    @Convert(converter = GenderConverter.class)
    private Gender gender;


    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Passport passport;
}
