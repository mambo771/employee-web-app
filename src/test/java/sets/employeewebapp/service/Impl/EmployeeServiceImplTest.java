package sets.employeewebapp.service.Impl;


import org.junit.jupiter.api.Test;
import sets.employeewebapp.exception.EmployeeAlreadyException;
import sets.employeewebapp.exception.EmployeeNotFoundException;
import sets.employeewebapp.exception.EmployeeStorageFullException;
import sets.employeewebapp.model.Employee;
import sets.employeewebapp.service.EmployeeValidationService;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sets.employeewebapp.EmployeeTestConstans.*;

class EmployeeServiceImplTest {
    private final EmployeeValidationService validationService = new EmployeeValidationServicImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(validationService);

    @Test
    public void shouldAddEmployee() {
        assertEquals(0, employeeService.findAll().size());
        Employee addedEmployee = employeeService.add(FirstName1, LastName1, Max_Salary, Department_Id1);
        assertEquals(1, employeeService.findAll().size());
        assertTrue(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeStorageFullException() {
        employeeService.add(FirstName1, LastName1, Max_Salary, Department_Id1);
        employeeService.add(FirstName2, LastName2, Max_Salary, Department_Id2);
        employeeService.add(FirstName3, LastName3, Min_Salary, Department_Id1);
        employeeService.add(FirstName4, LastName4, Max_Salary, Department_Id2);
        employeeService.add(FirstName5, LastName5, Max_Salary, Department_Id1);
        employeeService.add(FirstName6, LastName6, Min_Salary, Department_Id2);
        employeeService.add(FirstName7, LastName7, Max_Salary, Department_Id1);
        employeeService.add(FirstName8, LastName8, Max_Salary, Department_Id2);
        employeeService.add(FirstName9, LastName9, Max_Salary, Department_Id2);
        employeeService.add(FirstName10, LastName10, Min_Salary, Department_Id1);
        assertThrows(EmployeeStorageFullException.class,
                () -> employeeService.add(FirstName11, LastName11, Max_Salary, Department_Id1));
    }

    @Test
    public void shouldThrowEmployeeAlreadyException() {
        employeeService.add(FirstName1, LastName1, Max_Salary, Department_Id1);
        assertThrows(EmployeeAlreadyException.class,
                () -> employeeService.add(FirstName1, LastName1, Max_Salary, Department_Id1));

    }

    @Test
    public void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.add(FirstName1, LastName1, Max_Salary, Department_Id1);
        Employee removedEmployee = employeeService.remove(FirstName1, LastName1);
        assertFalse(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionRemove() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove(FirstName1, LastName1));
    }

    @Test
    public void shouldFindEmployee() {
        Employee addedEmployee = employeeService.add(FirstName1, LastName1, Max_Salary, Department_Id1);
        assertEquals(addedEmployee,employeeService.find(FirstName1, LastName1));
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionFind() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.find(FirstName1, LastName1));
    }
    @Test
    public void shouldFindAllEmployee(){
        Employee addedEmployee = employeeService.add(FirstName1, LastName1, Max_Salary, Department_Id1);
        Employee addedEmployee2 = employeeService.add(FirstName2, LastName2, Max_Salary, Department_Id1);
        Collection<Employee> addedEmployees = employeeService.findAll();
        assertIterableEquals(List.of(addedEmployee,addedEmployee2),addedEmployees);
    }
}
