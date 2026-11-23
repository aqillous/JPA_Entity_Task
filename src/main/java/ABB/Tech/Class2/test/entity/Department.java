package ABB.Tech.Class2.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true , length = 50)
    private String name;

    @Column(name = "location", nullable = false, length = 100)
    private String location;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        if (employees == null) {
            return;
        }

        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public void removeEmployee(Employee employee) {
        if (employees == null) {
            return;
        }

        if (employees.contains(employee)) {
            employees.remove(employee);
            employee.setDepartment(null);
        }
    }

}
