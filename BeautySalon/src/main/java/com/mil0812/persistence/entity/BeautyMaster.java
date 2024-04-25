package com.mil0812.learnspring.persistence.entity;

public class BeautyMaster extends Entity{
	private Client client;
	private int salary;
	private int experienceYear;

	public BeautyMaster(Integer id, Client client, int salary, int experienceYear) {
		super(id);
		this.client = client;
		this.salary = salary;
		this.experienceYear = experienceYear;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getExperienceYear() {
		return experienceYear;
	}

	public void setExperienceYear(int experienceYear) {
		this.experienceYear = experienceYear;
	}

	@Override
	public String toString() {
		return "BeautyMaster{" +
		    "client=" + client +
		    ", salary=" + salary +
		    ", experienceYear=" + experienceYear +
		    '}';
	}
}
