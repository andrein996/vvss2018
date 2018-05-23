package repository;

import model.Employee;
import validator.EmployeeValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepository implements EmployeeRepositoryInterface {

    private List<Employee> employeeList;
    private EmployeeValidator employeeValidator;

    public EmployeeRepository() {
        employeeValidator = new EmployeeValidator();
        employeeList = new ArrayList<Employee>();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if ( employeeValidator.isValid(employee)) {
            employeeList.add(employee);
            return true;
        }
        return false;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeList = employeeList
                .stream()
                .filter(employeeInList -> !employeeInList.getCnp().equals(employee.getCnp()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeByCriteria(String criteria) {
        // TODO Auto-generated method stub
        return null;
    }

}
