package sets.employeewebapp.model;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private String firstname;
    private String lastname;
    private int salary;
    private int departmentId;

    public Employee(String firstname, String lastname) {
        Random random = new Random();

        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = random.nextInt(10000) + 1000;
        this.departmentId = random.nextInt(5) + 1;
    }

    public Employee(String firstname, String lastname, int salary, int departmentId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getFullName() {
        return firstname + "  " + lastname;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstname, employee.firstname) && Objects.equals(lastname, employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
