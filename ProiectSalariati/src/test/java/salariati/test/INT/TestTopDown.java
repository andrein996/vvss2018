package salariati.test.INT;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeRepository;
import salariati.validator.EmployeeValidator;

import static org.junit.Assert.assertTrue;

public class TestTopDown {
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
        Employee newEmployee = new Employee("Andrei","Andr", "1961104260023", DidacticFunction.ASISTENT, 2000);
        assertTrue(employeeValidator.isValid(newEmployee));
        employeeController.addEmployee(newEmployee);
        assertTrue(employeeController.getEmployeesList().size() == 1);
        employeeRepository.deleteEmployee(newEmployee);
    }

    @Test
    public void TestIntegrareAB(){
        Employee employee1 = new Employee("Test", "Test", "1961104260023", DidacticFunction.ASISTENT, 300);
        Employee employee2 = new Employee("TestA", "TestA", "1923123231232", DidacticFunction.ASISTENT, 1993);
        Employee employee3 = new Employee("TestB", "TestB", "1924210324214", DidacticFunction.ASISTENT, 21312);

        //Testing Module A
        assertTrue(employeeRepository.addEmployee(employee1));
        assertTrue(employeeRepository.addEmployee(employee2));
        assertTrue(employeeRepository.addEmployee(employee3));
    }
}