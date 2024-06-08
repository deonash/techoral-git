package com.techoral.basic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
/**
 * 
 * Author: Techoral.com 
 * Description: To display the maximum salary of employees earning more than 30,000 using Java 8 Streams
 */
public class EmpMaxSalary {

	public static void main(String[] agrs) {
		
		List<Employee> empList = Arrays.asList(new EmpMaxSalary.Employee(1, "Avinash", 40000.1),
				new Employee(2, "techoral", 20000.1), new Employee(3, "com", 10000.1), new Employee(4, "test", 9000.1));

		Optional<Double> maxSalary = empList.stream().filter(emp -> emp.getSalary() > 30000).map(emp -> emp.getSalary())
				.max((a, b) -> Double.compare(a, b));

		maxSalary.ifPresent(salary -> System.out.println("Max Salary > 30000 is: " + salary));

	}

	static class Employee {
		int userid;
		String userName;
		double salary;

		public Employee(int userid, String userName, Double salary) {
			this.userid = userid;
			this.userName = userName;
			this.salary = salary;
		}

		public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

	}
}
