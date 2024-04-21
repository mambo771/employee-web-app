package sets.employeewebapp.service.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sets.employeewebapp.exception.EmployeeNotFoundException;
import sets.employeewebapp.service.EmployeeService;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static sets.employeewebapp.EmployeeTestConstans.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturtnTotalSalarySum() {
        when(employeeService.findAll())
                .thenReturn(EMPLOYEES);

        assertEquals(Department_total_Salary, departmentService.getDepartmentIdSalarySum(Department_Id1));

    }

    @Test
    public void shouldReturnEmployeeWithMaxSalary() {
        when(employeeService.findAll())
                .thenReturn(EMPLOYEES);

        assertEquals(Max_Salary_Employee, departmentService.findEmployeeWithMaxSalary(Department_Id1));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalary() {
        when(employeeService.findAll())
                .thenReturn(EMPLOYEES);

        assertEquals(Min_Salary_Employee, departmentService.findEmployeeWithMinSalary(Department_Id1));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionFindMaxSalary() {
        when(employeeService.findAll())
                .thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMaxSalary(Department_Id1));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionFindMinSalary() {
        when(employeeService.findAll())
                .thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMinSalary(Department_Id1));
    }

    @Test
    public void shouldFindEmployeeByDepartmentId() {
        when(employeeService.findAll()).
                thenReturn(Different_Department_Employees);
        assertEquals(singletonList(Max_Salary_Employee),departmentService.findEmployeeByDepartment(Department_Id1));
        assertEquals(singletonList(Different_Department_Employee),departmentService.findEmployeeByDepartment(Department_Id2));
    }

    @Test
    public void shouldReturnFindEmployeeByDepartmentId() {
        when(employeeService.findAll())
                .thenReturn(Different_Department_Employees);
        assertEquals(Employees_By_Department_Map,departmentService.findEmployeeByDepartment());
    }
}