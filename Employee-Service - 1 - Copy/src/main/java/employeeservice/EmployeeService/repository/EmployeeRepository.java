package employeeservice.EmployeeService.repository;

import employeeservice.EmployeeService.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
