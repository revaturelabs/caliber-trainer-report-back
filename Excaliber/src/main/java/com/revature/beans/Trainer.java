package com.revature.beans;

import javax.persistence.*;
import java.util.List;

/**
 * The type Trainer.
 */
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
            inverseJoinColumns = @JoinColumn(name = "batch_id"))
    private List<Batch> batches;


    /**
     * Instantiates a new Trainer.
     */
    public Trainer() {
        id = 0;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        employeeId = "";
        batches = null;
    }

    /**
     * Instantiates a new Trainer.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     */
    public Trainer(String firstName, String lastName, String email) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Instantiates a new Trainer.
     *
     * @param trainerId  the trainer id
     * @param firstName  the first name
     * @param lastName   the last name
     * @param email      the email
     * @param employeeId the employee id
     * @param batches    the batches
     */
    public Trainer(Integer trainerId, String firstName, String lastName, String email, String employeeId, List<Batch> batches) {
        this.id = trainerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.employeeId = employeeId;
        this.batches = batches;
    }

    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets new email.
     *
     * @param email New value of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets employeeId.
     *
     * @return Value of employeeId.
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets new employeeId.
     *
     * @param employeeId New value of employeeId.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets batches.
     *
     * @return Value of batches.
     */
    public List<Batch> getBatches() {
        return batches;
    }

    /**
     * Sets new batches.
     *
     * @param batches New value of batches.
     */
    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    /**
     * Gets lastName.
     *
     * @return Value of lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets new lastName.
     *
     * @param lastName New value of lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets firstName.
     *
     * @return Value of firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets new firstName.
     *
     * @param firstName New value of firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Integer getTrainerId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Integer id) {
        this.id = id;
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
