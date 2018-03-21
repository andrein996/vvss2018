package salariati.repository.implementations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import salariati.enumeration.DidacticFunction;
import salariati.exception.EmployeeException;

import salariati.model.Employee;

import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.validator.EmployeeValidator;

public class EmployeeDatabase implements EmployeeRepositoryInterface {
	
	private final String employeeDBFile = "employeeDB/employees.txt";
	private EmployeeValidator employeeValidator = new EmployeeValidator();

	@Override
	public boolean addEmployee(Employee employee) {
		if( employeeValidator.isValid(employee) ) {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(employeeDBFile, true));
				bw.write(employee.toString());
				bw.newLine();
				bw.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(employeeDBFile));
			String line;
			int counter = 0;
			while ((line = br.readLine()) != null) {
				try {
					Employee employee = getEmployeeFromString(line, counter);
					employeeList.add(employee);
				} catch(EmployeeException ex) {
					System.err.println("Error while reading: " + ex.toString());
				}
			}
		} catch (IOException e) {
			System.err.println("Error while reading: " + e);
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("Error while closing the file: " + e);
				}
		}
		
		return employeeList;
	}

	/**
	 * Returns the Employee after parsing the given line
	 *
	 * @param _employee
	 *            the employee given as String from the input file
	 * @param line
	 *            the current line in the file
	 *
	 * @return if the given line is valid returns the corresponding Employee
	 * @throws EmployeeException
	 */
	private Employee getEmployeeFromString(String _employee, int line) throws EmployeeException {
		Employee employee = new Employee();

		String[] attributes = _employee.split("[;]");

		if( attributes.length != 5 ) {
			throw new EmployeeException("Invalid line at: " + line);
		} else {
			EmployeeValidator validator = new EmployeeValidator();
			employee.setFirstName(attributes[1]);
			employee.setLastName(attributes[2]);
			employee.setCnp(attributes[3]);

			if(attributes[4].equals("ASISTENT_TEACHER"))
				employee.setFunction(DidacticFunction.ASISTENT_TEACHER);
			if(attributes[4].equals("ASISTENT"))
				employee.setFunction(DidacticFunction.ASISTENT);
			if(attributes[4].equals("LECTURER"))
				employee.setFunction(DidacticFunction.LECTURER);
			if(attributes[4].equals("TEACHER"))
				employee.setFunction(DidacticFunction.TEACHER);

			employee.setSalary(Integer.parseInt(attributes[5]));

			if( !validator.isValid(employee) ) {
				throw new EmployeeException("Invalid line at: " + line);
			}
		}

		return employee;
	}


	@Override
	public List<Employee> getEmployeeByCriteria(String criteria) {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		return employeeList;
	}

}
