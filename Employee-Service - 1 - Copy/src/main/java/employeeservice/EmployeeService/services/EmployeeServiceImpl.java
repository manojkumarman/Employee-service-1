package employeeservice.EmployeeService.services;

import employeeservice.EmployeeService.entities.Employee;
import employeeservice.EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl  implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee createEmp(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee updateEmp(Employee employee, Long id) {
        Employee editedEmp = repo.findById(id).get();
        BeanUtils.copyProperties(employee,editedEmp,"id");

        if(Objects.nonNull(employee.getUserId()) && !"".equalsIgnoreCase(employee.getUserId()))
            editedEmp.setUserId(employee.getUserId());
        if(Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName()))
            editedEmp.setFirstName(employee.getFirstName());
        if(Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName()))
            editedEmp.setLastName(employee.getLastName());
        if(Objects.nonNull(employee.getJobTitleName()) && !"".equalsIgnoreCase(employee.getJobTitleName()))
            editedEmp.setJobTitleName(employee.getJobTitleName());
        if(Objects.nonNull(employee.getPreferredFullName()) && !"".equalsIgnoreCase(employee.getPreferredFullName()))
            editedEmp.setPreferredFullName(employee.getPreferredFullName());
        if(Objects.nonNull(employee.getEmployeeCode()) && !"".equalsIgnoreCase(employee.getEmployeeCode()))
            editedEmp.setEmployeeCode(employee.getEmployeeCode());
        if(Objects.nonNull(employee.getRegion()) && !"".equalsIgnoreCase(employee.getRegion()))
            editedEmp.setRegion(employee.getRegion());
        if(Objects.nonNull(employee.getPhoneNumber()) && !"".equalsIgnoreCase(employee.getPhoneNumber()))
            editedEmp.setPhoneNumber(employee.getPhoneNumber());
        if(Objects.nonNull(employee.getEmailAddress()) && !"".equalsIgnoreCase(employee.getEmailAddress()))
            editedEmp.setEmailAddress(employee.getEmailAddress());

        return repo.save(editedEmp);
    }

    @Override
    public Employee getById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmp() {
        return null;
    }


    @Override
    public Page<Employee> getAllEmp(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public void deleteEmp(Employee employee) {
        repo.delete(employee);
    }
}
