package salariati.test.INT;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeRepository;
import salariati.validator.EmployeeValidator;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestBigBang {
    private EmployeeController employeeController;
    private EmployeeRepositoryInterface employeeRepository;
    private EmployeeValidator employeeValidator;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeRepository();
        employeeController = new EmployeeController(employeeRepository);
        employeeValidator = new EmployeeValidator();
    }

    @Test
    public void TestModulA() {
        Employee newEmployee = new Employee("Andrei","Andrei", "1961104260023", DidacticFunction.ASISTENT, 11);
        assertTrue(employeeValidator.isValid(newEmployee));
        employeeController.addEmployee(newEmployee);
        employeeRepository.deleteEmployee(newEmployee);
    }

    @Test
    public void TestModulC() {
        Employee employee1 = new Employee("Test", "Test", "1961104260023", DidacticFunction.ASISTENT, 300);
        Employee employee2 = new Employee("TestA", "TestA", "1923123231232", DidacticFunction.ASISTENT, 1993);
        Employee employee3 = new Employee("TestB", "TestB", "1924210324214", DidacticFunction.ASISTENT, 21312);

        assertTrue(employeeValidator.isValid(employee1));
        assertTrue(employeeValidator.isValid(employee2));
        assertTrue(employeeValidator.isValid(employee3));
        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);

        List<Employee> employeeList = employeeController.getEmployeesList();
        assertTrue(employeeList.get(0).equals(employee1));
        assertTrue(employeeList.get(1).equals(employee2));
        assertTrue(employeeList.get(2).equals(employee3));
        employeeRepository.deleteEmployee(employeeList.get(0));
        employeeRepository.deleteEmployee(employeeList.get(1));
        employeeRepository.deleteEmployee(employeeList.get(2));
    }
}
