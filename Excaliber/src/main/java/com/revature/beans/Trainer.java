package com.revature.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column
	private String email;
	@Column(name = "employee_Id")
	private String employeeId; // the trainer's ID from Caliber


	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "trainer_batch",
			joinColumns = @JoinColumn(name = "trainer_id"),
			inverseJoinColumns = @JoinColumn(name = "batch_id")) //needs column names--------------------------
	private Set<Batch> batches;


	public Trainer() {
		id = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		employeeId = "";
		batches = null;
	}

	public Trainer(String firstName, String lastName, String email) {
		this.id = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		//this.employeeId = employeeId;
		//this.batches = batches;
	}

	public Integer getTrainerId() {
		return id;
	}

	public void setTrainerId(Integer trainerId) {
		this.id = trainerId;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Trainer(Integer trainerId, String firstName, String lastName, String email, String employeeId, Set<Batch> batches) {
		this.id = trainerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeId = employeeId;
		this.batches = batches;
	}

	@Override
	public String toString() {
		return "Trainer{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", employeeId='" + employeeId + '\'' +
				", batches=" + batches +
				'}';
	}
}
