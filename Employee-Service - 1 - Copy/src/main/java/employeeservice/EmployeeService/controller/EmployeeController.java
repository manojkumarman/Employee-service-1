package employeeservice.EmployeeService.controller;


import employeeservice.EmployeeService.entities.Employee;
import employeeservice.EmployeeService.services.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {


    @Autowired
    EmployeeServiceInterface service;

    //create emp
    @PostMapping("/")
    public Employee createEmp(@RequestBody Employee employee){
        return service.createEmp(employee);
    }

    // update emp
    @PutMapping("/{id}")
    public Employee updateEmp(@RequestBody Employee employee,@PathVariable("id")Long id){
        return service.updateEmp(employee,id);
    }

    //get by id
    @GetMapping("/{id}")
    public Employee getEmpById(@PathVariable("id") Long id){
        Employee employee = service.getById(id);
        return employee;
    }

    //get all with pagination
    @GetMapping("/")
    public List<Employee> employeeList(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employees = (Page<Employee>) service.getAllEmp(pageable);
        return employees.getContent();
    }
    //Delete
    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable("id")Long id ){
        Employee employee = service.getById(id);
        service.deleteEmp(employee);
    }
}
