package com.techoral.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSortByDept {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "john", "HR", LocalDate.of(2024, 3, 1)));
		empList.add(new Employee(1, "doe", "IT", LocalDate.of(2022, 4, 1)));
		empList.add(new Employee(1, "tomm", "HR", LocalDate.of(2021, 6, 1)));
		empList.add(new Employee(1, "harry", "IT", LocalDate.of(2020, 8, 1)));

		Collections.sort(empList, new CustomEmployeeSort());
		
		for(Employee e: empList)
		{
			System.out.println(e.getName() + " "+ e.getDept()+ " "+e.getDoj());
		}

	}

}

class CustomEmployeeSort implements Comparator<Employee>

{

	@Override
	public int compare(Employee e1, Employee e2) {

		int sortDept = e1.getDept().compareTo(e2.getDept());
		if (sortDept != 0) {
			return sortDept;
		} else {
			return e1.getDoj().compareTo(e2.getDoj());

		}
	}

}

class Employee {
	private int id;
	private String name;
	private String dept;
	private LocalDate doj;

	public Employee(int id, String name, String dept, LocalDate doj) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.doj = doj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

}
