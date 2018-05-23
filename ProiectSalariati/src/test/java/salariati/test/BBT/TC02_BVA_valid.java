package salariati.test.BBT;

import org.junit.Before;
import org.junit.Test;
import salariati.enumeration.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeRepository;
import salariati.validator.EmployeeValidator;

import static org.junit.Assert.assertTrue;

public class TC02_BVA_valid {
    private EmployeeRepositoryInterface employeeRepository;
    private EmployeeValidator employeeValidator;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeRepository();
        employeeValidator  = new EmployeeValidator();
    }

    @Test
    public void TCAddNewEmployee() {
        Employee newEmployee = new Employee("Andrei","Ana", "1961104260023", DidacticFunction.TEACHER, 20);
        assertTrue(employeeValidator.isValid(newEmployee));
        assertTrue(employeeRepository.addEmployee(newEmployee));
    }
}