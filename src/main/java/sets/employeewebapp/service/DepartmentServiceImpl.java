package sets.employeewebapp.service;

import org.springframework.stereotype.Service;
import sets.employeewebapp.exception.EmployeeNotFoundException;
import sets.employeewebapp.model.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
       return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeeByDepartment(int departmentId) {
        employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .sorted(comparing(Employee::getFullName))
                .collect(Collectors.toList());
        return null;
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeeByDepartment() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
