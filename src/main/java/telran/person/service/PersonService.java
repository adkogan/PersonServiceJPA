package telran.person.service;

import telran.person.domain.Address;
import telran.person.domain.Employee;
import telran.person.domain.Person;
import telran.person.dto.ChildDto;
import telran.person.dto.CityPopulation;
import telran.person.dto.CompanySalary;

public interface PersonService {
	
	void addPerson(Person person);
	
	Person getPerson(int id);
	
	boolean removePerson(int id);
	 
	boolean updateAddress(int id, Address address);
	
	Iterable<Person> getPersonByAge(int minAge, int maxAge);
	
	Iterable<Person> getPersonCity(String city);
	
	Iterable<Person> getEmployeeBySalary(int minSalary, int maxSalary);

	Iterable<ChildDto> getChildren();
	
	Iterable<CityPopulation> getCityPopulations();
	
	Iterable<Employee> getEmployeesCompany(String company);
	
	Iterable<Employee> getEmployeesBigestCompany();
	
	Iterable<CompanySalary> getCompaniesSalaries();
	

}
