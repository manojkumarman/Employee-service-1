package employeeservice.EmployeeService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import employeeservice.EmployeeService.entities.Employee;
import employeeservice.EmployeeService.services.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
class EmployeeControllerTest {

    @MockBean
    public EmployeeServiceImpl employeeService;

    @InjectMocks
    public EmployeeController employeeController;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
    @BeforeEach
    public void setMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void createEmp() throws Exception {
        Employee emp = new Employee(1L,"rirani","developer","roma","Irani","rirani","1c","india","26734519","abcd");

        //mocking
        Mockito.when(employeeService.createEmp(emp)).thenReturn(emp);

        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(emp);

        mockMvc.perform(post("/emp/")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andDo(print());
    }

    @Test
    void updateEmp() {
    }

    @Test
    void getEmpById() {
    }

    @Test
    void employeeList() {
    }

    @Test
    void deleteEmp() {
    }
}