package sets.employeewebapp.controller;

import org.springframework.web.bind.annotation.*;
import sets.employeewebapp.model.Employee;
import sets.employeewebapp.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("{depatrmentsId}/salary/sum")
    public Integer getDepartmentIdSalarySum(@PathVariable int departmentId) {
        return departmentService.getDepartmentIdSalarySum(departmentId);
    }

    @GetMapping("{depatrmentsId}/salary/max")
    public Employee findEmployeeWithMaxSalary(@PathVariable int departmentId) {
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("{depatrmentsId}/salary/min")
    public Employee findEmployeeWithMinSalary(@PathVariable int departmentId) {
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }
    @GetMapping(value = "{depatrmentsId}/employees",params =  {"departmentId"})
    public Collection<Employee> findEmployeeByDepartments(@PathVariable int departmentId) {
        return departmentService.findEmployeeByDepartment(departmentId);
    }
    @GetMapping("employees")
    public Map<Integer, List<Employee>> findEmployeeByDepartments() {
        return departmentService.findEmployeeByDepartment();
    }
}
