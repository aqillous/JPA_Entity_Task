package ABB.Tech.Class2.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Check(name = "chk_employee_salary" , constraints = "salary >= 0")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    //double uses binary floating-point representation, which can introduce precision errors in financial calculations.
    //BigDecimal provides accurate decimal arithmetic, making it appropriate for money.

    @Column(name = "salary", nullable = false, precision = 10 , scale = 2)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(
            name = "department_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_employee_department"))
    private Department department;
}
