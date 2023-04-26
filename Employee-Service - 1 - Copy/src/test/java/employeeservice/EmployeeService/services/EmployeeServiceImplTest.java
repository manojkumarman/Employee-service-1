package employeeservice.EmployeeService.services;

import employeeservice.EmployeeService.entities.Employee;
import employeeservice.EmployeeService.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository repo;

    @InjectMocks
    EmployeeServiceImpl employeeService;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEmp() {
        Employee emp = new Employee(1L, "rirani", "developer", "roma", "Irani", "rirani", "1c", "india", "26734519", "abcd");

        //mocking
        Mockito.when(repo.save(any(Employee.class))).thenReturn(emp);
        assertEquals(1L, employeeService.createEmp(emp).getId());
    }

    @Test
    void updateEmp() {
        Employee emp = new Employee(1L, "rirani", "developer", "romin", "Irani", "Romin Irani", "E1", "CA", "408-1234567", "romin.kirani@gmail.com");

        Employee updatedEmp = new Employee(1L, "rirani", "developer", "romin", "Irani", "Romin Irani", "E1", "CA", "408-1234567", "romin.kirani@gmail.com");

        //mocking
        Mockito.when(repo.findById(anyLong())).thenReturn(Optional.of(emp));
        Mockito.when(repo.save(any(Employee.class))).thenReturn(updatedEmp);
        Employee updated = employeeService.updateEmp(emp, 1L);
        assertEquals(updatedEmp.getUserId(), updated.getUserId());
    }

    @Test
    void getById() {
        Employee emp = new Employee(1L, "rirani", "developer", "romin", "Irani", "Romin Irani", "E1", "CA", "408-1234567", "romin.kirani@gmail.com");
        Long id = 1L;

        //mocking
        Mockito.when(repo.findById(id)).thenReturn(Optional.of(emp));
        assertEquals(id, employeeService.getById(id).getId());
    }

    @Test
    public void testGetAllEmp() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1L, "rirani", "developer", "romin", "Irani", "Romin Irani", "E1", "CA", "408-1234567", "romin.kirani@gmail.com"));
        empList.add(new Employee(2L, "manu", "developer", "manoj", "Kumar", "Manoj Kumar", "C1", "IN", "267-3451900", "manoj.kumar@gamil.com"));
        empList.add(new Employee(3L, "raj", "developer", "raja", "Vardhan", "Raja Vardhan", "D1", "US", "808-2314576", "raja.vardhan@gmail.com"));
        empList.add(new Employee(4L, "shiva", "developer", "shivaraj", "Rajkumar", "Shivaraj Rajkumar", "B1", "UK", "809-4314576", "shivaraj.rajkumar@gmail.com"));
        empList.add(new Employee(5L, "appu", "developer", "puneeth", "Rajkumar", "Puneeth Rajkumar", "A1", "KA", "123-2314578", "puneeth.rajkumar@gmail.com"));
        Pageable pageable = PageRequest.of(1, 5);
        // Mocking
        // Mock the repository method
        Mockito.when(repo.findAll(Mockito.any(Pageable.class))).thenReturn(new PageImpl<>(empList));

        // Call the service method
        List<Employee> result = employeeService.getAllEmp(pageable).getContent();

        // Assert that the returned list is not null
        assertNotNull(result);
        // If the returned list is empty, assert that there was no data
        if (result.isEmpty()) {
            assertEquals(0, empList.size());
        } else {
            // Assert other conditions
            assertEquals(empList.size(), result.size());
            assertEquals(empList.get(0).getUserId(), result.get(0).getUserId());
            assertEquals(empList.get(1).getUserId(), result.get(1).getUserId());
            assertEquals(empList.get(2).getUserId(), result.get(2).getUserId());
            assertEquals(empList.get(3).getUserId(), result.get(3).getUserId());
            assertEquals(empList.get(4).getUserId(), result.get(4).getUserId());

        }
    }
}