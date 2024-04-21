package sets.employeewebapp;

import sets.employeewebapp.model.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstans {
    public static final String FirstName1 = "Ivan";
    public static final String LastName1 = "Ivanov";
    public static final String FirstName2 = "Petr";
    public static final String LastName2 = "Petrov";
    public static final String FirstName3 = "Semen";
    public static final String LastName3 = "Semenov";
    public static final String FirstName4 = "Egor";
    public static final String LastName4 = "Egorov";
    public static final String FirstName5 = "Alex";
    public static final String LastName5 = "Alexeev";
    public static final String FirstName6 = "Roman";
    public static final String LastName6 = "Romanov";
    public static final String FirstName7 = "Ilya";
    public static final String LastName7 = "Ilyin";
    public static final String FirstName8 = "Usup";
    public static final String LastName8 = "Usupov";
    public static final String FirstName9 = "Igor";
    public static final String LastName9 = "Igorev";
    public static final String FirstName10 = "Nikita";
    public static final String LastName10 = "Nikitin";
    public static final String FirstName11 = "Vasiliy";
    public static final String LastName11 = "Vasilyev";
    public static final String No_corect_FirstName = "Semen313$";
    public static final String No_corect_LastName = "Semenov43%#$#";
    public static final int Min_Salary = 1000;
    public static final int Max_Salary = 100_000;
    public static final int Department_Id1 = 1;
    public static final int Department_Id2 = 2;
    public static final Employee Max_Salary_Employee = new Employee(FirstName1, LastName1, Max_Salary, Department_Id1);
    public static final Employee Min_Salary_Employee = new Employee(FirstName2, LastName2, Min_Salary, Department_Id1);
    public static final Employee Different_Department_Employee = new Employee(FirstName3, LastName3, Min_Salary, Department_Id2);

    public static final List<Employee> EMPLOYEES = List.of(Max_Salary_Employee, Min_Salary_Employee);
    public static final List<Employee> Different_Department_Employees = List.of(Max_Salary_Employee, Different_Department_Employee);
    public static final Integer Department_total_Salary = EMPLOYEES.stream().mapToInt(Employee::getSalary).sum();
    public static final Map<Integer, List<Employee>> Employees_By_Department_Map =
            Different_Department_Employees.stream()
                    .collect(groupingBy(Employee::getDepartmentId));
}