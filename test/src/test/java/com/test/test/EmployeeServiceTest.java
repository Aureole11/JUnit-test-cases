package com.test.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.test.model.Employee;
import com.test.test.model.service.EmployeeServiceImpl;
import com.test.test.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {

	@Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;   

    @Test
    public void getAllEmployees(){
    	
    	Employee employee1 = new Employee();
    	employee1.setId(1);
    	employee1.setFirstName("Kamal");
    	employee1.setLastName("Bansal");
    	employee1.setEmail("kamal@gmail.com");
    	
//    	Mockito.when(employeeRepository.findAll()).thenReturn(Collections.emptyList());
//    	
//    	List<Employee> employeeList = employeeService.getAllEmployees();
//
//    	
//    	 assertThat(employeeList).isEmpty();
//         assertThat(employeeList.size()).isEqualTo(0);
         
         
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(employee1));

        List<Employee> employeeList = employeeService.getAllEmployees();

        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(1);
    }
    
    @Test
    public void saveEmployee() {
    	
    	Employee employee1 = new Employee();
    	employee1.setId(2);
    	employee1.setFirstName("Kamal");
    	employee1.setLastName("Bansal");
    	employee1.setEmail("kamal@gmail.com");
    	
    	Mockito.when(employeeRepository.save(employee1)).thenReturn(employee1);
    	
    	assertThat(employeeService.saveEmployee(employee1)).isEqualTo(employee1);
    }
    
    @Test
    public void getEmployeeById() {
    	Employee employee1 = new Employee();
    	employee1.setId(2);
    	employee1.setFirstName("Kamal");
    	employee1.setLastName("Bansal");
    	employee1.setEmail("kamal@gmail.com");
    	
    	Mockito.when(employeeRepository.findById(2L)).thenReturn(Optional.of(employee1));
    	Employee service = employeeService.getEmployeeById(employee1.getId()).get();
    	
    	assertThat(service.getId()).isNotNull();
    }
    
    @Test
    public void updateEmployee() {
    	Employee employee1 = new Employee();
    	employee1.setId(2);
    	employee1.setFirstName("Kamal");
    	employee1.setLastName("Bansal");
    	employee1.setEmail("kamal@gmail.com");
    	
    	Mockito.when(employeeRepository.save(employee1)).thenReturn(employee1);
    	employee1.setFirstName("Vinod");
    	employee1.setEmail("vinod@gmail.com");
    	
    	Employee updateEmployee = employeeService.updateEmployee(employee1);
    	
    	assertThat(updateEmployee.getFirstName()).isEqualTo("Vinod");
    	assertThat(updateEmployee.getEmail()).isEqualTo("vinod@gmail.com");
    }
    
    @Test
    public void deleteEmployee() {
    	Employee employee1 = new Employee();
    	employee1.setId(2);
    	employee1.setFirstName("Kamal");
    	employee1.setLastName("Bansal");
    	employee1.setEmail("kamal@gmail.com");
    	
    	long employeeId =2L;
    	
    	 doNothing().when(employeeRepository).deleteById(employeeId);
         employeeService.deleteEmployee(employeeId);

         verify(employeeRepository, times(1)).deleteById(employeeId);
    }

}
