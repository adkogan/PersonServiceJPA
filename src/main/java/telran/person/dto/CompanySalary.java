package telran.person.dto;

import java.io.Serializable;

public class CompanySalary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String company;
	double salary;
	
	public CompanySalary(String company, double salary) {
		this.company = company;
		this.salary = salary;
	}

	public CompanySalary() {
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	

	
	

}
