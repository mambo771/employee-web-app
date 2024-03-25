package sets.employeewebapp.service;

import org.springframework.stereotype.Service;
import sets.employeewebapp.exception.EmployeeAlreadyException;
import sets.employeewebapp.exception.EmployeeNotFoundException;
import sets.employeewebapp.exception.EmployeeStorageFullException;
import sets.employeewebapp.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private final  EmployeeValidationService employeeValidationService;

    public EmployeeServiceImpl(EmployeeValidationService employeeValidationService) {
        this.employeeValidationService = employeeValidationService;
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        return add(employee);
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private Employee add(Employee employee) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE) {
            throw new EmployeeStorageFullException();
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyException();
        }
        employeeValidationService.validate(employee.getFirstname(), employee.getLastname());
        employees.put(employee.getFullName(), employee);
        return employee;
    }
}