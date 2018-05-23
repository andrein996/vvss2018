package repository;

import model.Employee;

import java.util.List;

public interface EmployeeRepositoryInterface {

    boolean addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void modifyEmployee(Employee oldEmployee, Employee newEmployee);
    List<Employee> getEmployeeList();
    List<Employee> getEmployeeByCriteria(String criteria);

}
