package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

public class Trainer {
	private Integer trainerId;
	private String firstName;
	private String lastName;
	private String email;
	private String employeeId; // the trainer's ID from Caliber
	private Set<Batch> batches = new HashSet<Batch>();

	public Trainer(String firstName, String lastName, String email, String name) {
		trainerId = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		employeeId = "";
		batches = null;
	}

	public Trainer(String firstName, String lastName, String email) {
		this.trainerId = trainerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeId = employeeId;
		this.batches = batches;
	}

	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Set<Batch> getBatches() {
		return batches;
	}

	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}

	public Trainer(Integer trainerId, String firstName, String lastName, String email, String employeeId, Set<Batch> batches) {
		this.trainerId = trainerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeId = employeeId;
		this.batches = batches;
	}
}
