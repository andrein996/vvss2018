package salariati.model;

import salariati.enumeration.DidacticFunction;
import salariati.exception.EmployeeException;
import salariati.validator.EmployeeValidator;

public class Employee {

	/** The first name of the employee*/
	private String firstName;

	/** The last name of the employee */
	private String lastName;
	
	/** The unique id of the employee */
	private String cnp;
	
	/** The didactic function of the employee inside the university */
	private DidacticFunction function;
	
	/** The salary of the employee */
	private Integer salary;
	
	/**
	 * Default constructor for employee
	 */
	public Employee() {
		this.firstName = "";
		this.lastName  = "";
		this.cnp       = "";
		this.function  = DidacticFunction.ASISTENT;
		this.salary    = 0;
	}
	
	/**
	 * Constructor with fields for employee
	 */
	public Employee(String firstName, String lastName, String cnp, DidacticFunction function, Integer salary) {
		this.firstName = firstName;
		this.lastName  = lastName;
		this.cnp       = cnp;
		this.function  = function;
		this.salary    = salary;
	}

	/**
	 * Getter for the employee last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter for the employee last name
	 * 
	 * @param lastName the last name to be set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter for the employee CNP
	 */
	public String getCnp() {
		return cnp;
	}

	/**
	 * Setter for the employee CNP
	 * 
	 * @param cnp the CNP to be set
	 */
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	/**
	 * Getter for the employee didactic function
	 */
	public DidacticFunction getFunction() {
		return function;
	}

	/**
	 * Setter for the employee function
	 * 
	 * @param function the function to be set
	 */
	public void setFunction(DidacticFunction function) {
		this.function = function;
	}

	/**
	 * Getter for the employee salary
	 */
	public Integer getSalary() {
		return salary;
	}

	/**
	 * Setter for the salary
	 * 
	 * @param salary the salary to be set
	 */
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * toString function for employee
	 */
	@Override
	public String toString() {
		String employee = "";

		employee += firstName + ";";
		employee += lastName + ";";
		employee += cnp + ";";
		employee += function.toString() + ";";
		employee += salary;
		
		return employee;
	}
	
	/**
	 * equals function for employee
	 */
	public boolean equals(Employee comparableEmployee) {
		boolean hasSameFirstName = this.firstName.equals(comparableEmployee.getFirstName()),
				hasSameLastName  = this.lastName.equals(comparableEmployee.getLastName()),
				hasSameCNP       = this.cnp.equals(comparableEmployee.getCnp()),
				hasSameFunction  = this.function.equals(comparableEmployee.getFunction()),
				hasSameSalary    = this.salary.equals(comparableEmployee.getSalary());
		return hasSameFirstName && hasSameLastName && hasSameCNP && hasSameFunction && hasSameSalary;
	}

}
