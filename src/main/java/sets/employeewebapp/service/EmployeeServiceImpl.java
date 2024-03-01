package sets.employeewebapp.service;

import org.springframework.stereotype.Service;
import sets.employeewebapp.exception.EmployeeAlreadyException;
import sets.employeewebapp.exception.EmployeeNotFoundException;
import sets.employeewebapp.exception.EmployeeStorageFullException;
import sets.employeewebapp.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE){
            throw new EmployeeStorageFullException();
        }
        Employee employee = new Employee(firstName,lastName);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
            employees.remove(employee);
            return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees;
    }
}