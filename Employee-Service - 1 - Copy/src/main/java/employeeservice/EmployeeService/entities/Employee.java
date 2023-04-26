package employeeservice.EmployeeService.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String jobTitleName;
    private String firstName;
    private String lastName;
    private String preferredFullName;
    private String employeeCode;
    private String region;
    private String phoneNumber;
    private String emailAddress;

}
