package telran.person.dao;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.person.domain.Employee;
import telran.person.domain.Person;
import telran.person.dto.ChildDto;
import telran.person.dto.CityPopulation;
import telran.person.dto.CompanySalary;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	List <Person> findByBirthDateBetween(LocalDate from, LocalDate to);
	
	
	List<Person> findByAddressCity(String city);
	
	
	//@Query("SELECT * FROM person WHERE salary BETWEEN :minSalary AND :maxSalary")(@param("minSalary" int minSalary...)
	@Query("select p from Person p where p.salary between ?1 and ?2")
	List<Person> findBySalaryBetween(int minSalary, int maxSalary);

	@Query("select new telran.person.dto.ChildDto(p.name, p.address.city, p.kindergarten) from Person p where p.kindergarten is not null")
	Iterable<ChildDto> findChildren();
	
	@Query("select new telran.person.dto.CityPopulation(p.address.city, count(p)) from Person p group by p.address.city order by count(p) desc ")
	Iterable<CityPopulation> getCityPopulations();
	
	//SELECT * FROM employee WHERE company = 'IBM'
	@Query("select p from Employee p where p.company = :company")
	Iterable<Employee> findEmployeesByCompany (@Param("company") String company);
	
	
	//SELECT Company FROM employee GROUP BY company  order by count (*) desc);
	@Query("select company FROM Employee e GROUP BY e.company  order by count (e) desc")
	Iterable<String> findCompanyWithMostEmployees();
	
	
	
	//@Query("select e.company, AVG(e.salary) from employee e group by company")
	@Query("select new telran.person.dto.CompanySalary(e.company, avg(e.salary)) from Employee e group by e.company order by avg(e.salary) desc ")
	Iterable<CompanySalary> findCompanyBySalaries();
	
}
