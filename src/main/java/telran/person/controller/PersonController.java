package telran.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.person.domain.Address;
import telran.person.domain.Employee;
import telran.person.domain.Person;
import telran.person.dto.ChildDto;
import telran.person.dto.CityPopulation;
import telran.person.dto.CompanySalary;
import telran.person.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping("/person/")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable int id) {
		return personService.getPerson(id);	
	}
	@PutMapping("/person/{id}/address/")
	public boolean updateAddress(@PathVariable int id, @RequestBody Address address) {
		return personService.updateAddress(id, address);
	}
	
	@DeleteMapping("/person/{id}")
	public boolean removePerson(@PathVariable int id) {
		return personService.removePerson(id);	
	}
	

	@GetMapping("/persons/salary/{min}/{max}")
	public Iterable<Person> getEmployeeBySalary(@PathVariable int min, @PathVariable int max){
		return personService.getEmployeeBySalary(min, max);
	}
	
	@GetMapping("/persons/age/{min}/{max}")
	public Iterable<Person> getPersonByAge(@PathVariable int min, @PathVariable int max){
		return personService.getPersonByAge(min, max);
	}
	
	
	
	@GetMapping("/persons/populations/")
	public Iterable<CityPopulation> getCityPopulations() {
		return personService.getCityPopulations();
	}

	
	@GetMapping("/persons/children/")
	public Iterable<ChildDto> getChildren() {
		return personService.getChildren();
	}
	
	
	@GetMapping("/companies")
	public Iterable<CompanySalary> getCompaniesSalaries(){
		return personService.getCompaniesSalaries();
	}
	
	@GetMapping("/employees")
	public Iterable <Employee> getEmployeesBigestCompany() {
		return personService.getEmployeesBigestCompany();
	}
	
	@GetMapping("/employees/{company}")
	public Iterable <Employee> getEmployeesCompany(@PathVariable String company){
		return personService.getEmployeesCompany(company);
	}
}
	
	

