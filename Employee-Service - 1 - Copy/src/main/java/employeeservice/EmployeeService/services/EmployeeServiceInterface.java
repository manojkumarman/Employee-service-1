package employeeservice.EmployeeService.services;

import employeeservice.EmployeeService.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeServiceInterface {

    Employee createEmp(Employee employee);

    Employee updateEmp(Employee employee, Long id);

    Employee getById(Long id);

    List<Employee> getAllEmp();
    void deleteEmp(Employee employee);
    Page<Employee> getAllEmp(Pageable pageable);

}
