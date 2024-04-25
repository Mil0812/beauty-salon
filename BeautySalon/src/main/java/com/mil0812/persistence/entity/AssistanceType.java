package com.mil0812.learnspring.persistence.entity;

public class AssistanceType extends Entity{
	private String name;
	private String description;
	private int salary;

	public AssistanceType(Integer id, String name, String description, int salary) {
		super(id);
		this.name = name;
		this.description = description;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "AssistanceType{" +
		    "name='" + name + '\'' +
		    ", description='" + description + '\'' +
		    ", salary=" + salary +
		    '}';
	}
}
