package com.techoral.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Author: www.techoral.com
 * 
 * Description :  finding the employee with the maximum salary greater than 30,000 using Java streams
 * 
 */

public class EmpMaxSalary {

	static class Employee {
		String name;
		Double salary;

		public Employee(String name, Double salary) {
			this.name = name;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		// getters and setters

	}

	public static void main(String[] args) {

		List<Employee> employeeList = Arrays.asList(

				new Employee("techoral", 45000.0), 

			

				new Employee("Avi", 55000.0),

				new Employee("Kevin", 55000.0),
				new Employee("Nash", 25000.0),

				new Employee("guru", 15000.0),
				new Employee("com", 35000.0)
		);

		Optional<Employee> empMax = employeeList.stream().filter(emp -> emp.getSalary() > 30000).sorted((a, b) -> {
			int maxSal = Double.compare(b.getSalary(), a.getSalary());

			if (maxSal == 0) {
				return a.getName().compareTo(b.getName());
			}
			return maxSal;
		}

		).findFirst();
		System.out.println(empMax.map(e -> "Empname with Max salary: " + e.getName() + " : " + e.getSalary())
				.orElse("No Employee with greaterthan 30000"));

	}

}
