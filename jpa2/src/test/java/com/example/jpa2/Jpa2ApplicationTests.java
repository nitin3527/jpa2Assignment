package com.example.jpa2;

import com.example.jpa2.entity.*;
import com.example.jpa2.repositories.EmployeeMappingRepository;
import com.example.jpa2.repositories.EmployeeRepository;
import com.example.jpa2.repositories.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class Jpa2ApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	EmployeeMappingRepository employeeMappingRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testEmployeHavingSalaryGreaterThanAvgSal(){
		List<Object[]> empData = repository.finadAllEmployee();
		for(Object[] obj: empData){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}
	@Test
	//@Rollback(value = true)
	public void testUpdateSalaryOfEmployeeLessThanAvg(){
		double salary = 6800;
		repository.updateSalaryOfEmployeeLessThanAvg(salary);
	}

	@Test
	@Transactional
	public void testDeleteEmployeeSalary(){
		repository.deleteEmployeeSalary();
	}
	@Test
	public void testgetAllEmployeeWhoesNameEndsWith(){
		List<Object[]> empData = repository.getAllEmployeeWhoesNameEndsWith();
		for(Object[] obj: empData){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void testdeleteEmployeeHaingAgeGreaterThan(){
		repository.deleteEmployeeHaingAgeGreaterThan(45);
	}

	//payment tests for single_table
	/*
	@Test
	public void createPayment(){
		CreditCard cc = new CreditCard();
		cc.setId(1);
		cc.setAmount(5000);
		cc.setCardnumber("555147963");
		paymentRepository.save(cc);
	}

	 */
	//payment tests for single_table
	@Test
	public void createPayment(){
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setAmount(5000);
		cc.setCardnumber("555147963");
		paymentRepository.save(cc);
	}
	@Test
	public void createCheckPayment(){
		Check ch = new Check();
		ch.setId(1);
		ch.setAmount(5000);
		ch.setCheckNumber("555147963");
		paymentRepository.save(ch);
	}

	@Test
	public void createNewStudent(){
		EmployeeMapping emp = new EmployeeMapping();
		emp.setId(1);
		emp.setFirstname("Nitin");
		emp.setLastname("khandelwal");
		emp.setAge(23);
		Salary sal = new Salary();
		sal.setBasicsalary(5600);
		sal.setBonussalary(1200);
		sal.setSpecialallowancesalary(800);
		sal.setTaxamount(600);
		emp.setSalary(sal);
		employeeMappingRepository.save(emp);
	}

}
