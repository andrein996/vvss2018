package salariati.test;

import static org.junit.Assert.*;
import salariati.model.Employee;

import org.junit.Before;
import org.junit.Test;

import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeRepository;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;

public class AddEmployeeTest {

	private EmployeeRepositoryInterface employeeRepository;
	private EmployeeController controller;
	private EmployeeValidator employeeValidator;
	
	@Before
	public void setUp() {
		employeeRepository = new EmployeeRepository();
		controller         = new EmployeeController(employeeRepository);
		employeeValidator  = new EmployeeValidator();
	}
	
	@Test
	public void testRepositoryMock() {
		assertTrue(controller.getEmployeesList().isEmpty());
		assertEquals(0, controller.getEmployeesList().size());
	}
	
	@Test
	public void testAddNewEmployee() {
		Employee newEmployee = new Employee("ValidFirstName", "ValidLastName", "1910509055057", DidacticFunction.ASISTENT, 3000);
		assertTrue(employeeValidator.isValid(newEmployee));
		controller.addEmployee(newEmployee);
		assertEquals(1, controller.getEmployeesList().size());
		assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
	}

}
