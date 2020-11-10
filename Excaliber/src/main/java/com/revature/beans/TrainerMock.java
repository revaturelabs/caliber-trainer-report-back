package com.revature.beans;

import java.util.List;

public class TrainerMock {

	private String firstName;
	private String lastName;
	private String email;
	private List<Batch> batches;
	
	public TrainerMock(String firstName, String lastName, String email, List<Batch> batches) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.batches = batches;
	}
	
	public TrainerMock() {
		super();
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
	
	public List<Batch> getBatches() {
		return batches;
	}
	
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
	
	@Override
	public String toString() {
		return "TrainerMock [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", batches="
				+ batches + "]";
	}
	
	
}
