/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.data;

import java.beans.PropertyChangeSupport;

/**
 * The <code>Student</code> class that represents a student and is used by the
 * <code>StudentDB</code> and <code>StudentManagerFrame</code> classes.
 *
 * @author salisu14
 */
public class Student {

    private String jambNo;
    private String firstName;
    private String middle;
    private String lastName;
    private String gender;
    private String state;
    private int aggregate;
    private String courseName;
    private String localGovernment;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     *Creates a <code>Student</code> with default values.
     */
    public Student() {
        jambNo = "";
        firstName = "";
        middle = "";
        lastName = "";
        gender = "Male";
        state = "";
        aggregate = 0;
        courseName = "";
        localGovernment = "";
    }
    /**
     * Create a <code>Student</code> with the following parameters:
     * @param jambNo
     * @param firstName
     * @param middle
     * @param lastName
     * @param gender
     * @param state
     * @param aggregate
     * @param courseName
     * @param localGovernment 
     */
    public Student(String jambNo, String firstName, String middle, String lastName,
            String gender, String state, int aggregate, String courseName,
            String localGovernment) {
        this.jambNo = jambNo;
        this.firstName = firstName;
        this.middle = middle;
        this.lastName = lastName;
        this.gender = gender;
        this.state = state;
        this.aggregate = aggregate;
        this.courseName = courseName;
        this.localGovernment = localGovernment;
    }

    /**
     * Returns a <code>String</code> that represents the student Jamb number
     * @return jambNo A <code>String</code> for the Jamb number
     */
    public String getJambNo() {
        return jambNo;
    }

    /**
     * Sets the jamb number to the specified <code>String</code>
     * @param jambNo A <code>String</code> for the specified jambNo
     */
    public void setJambNo(String jambNo) {
        this.jambNo = jambNo;
    }

    /**
     * Return a <code>String</code> representing the student first name
     * @return firstName A <code>String</code> for the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name with the specified <code>String</code>
     * @param firstName A <code>String</code> for the student first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return a <code>String</code> for the student middle name
     * @return middle A <code>String</code> for the student's middle name
     */
    public String getMiddle() {
        return middle;
    }

    /**
     * Sets the middle name to the specified <code>String</code>
     * @param middle A <code>String</code> for the middle name.
     */
    public void setMiddle(String middle) {
        this.middle = middle;
    }

    /**
     * Returns a <code>String</code> for the student's last name
     * @return lastName A <code>String</code> for the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name to the specified <code>String</code>
     * @param lastName A <code>String</code> for the last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a <code>String</code> for the student's gender
     * @return gender A <code>String</code> for the gender
     * This method return a <b>Male</b> string if the gender is null.
     */
    public String getGender() {
        return (gender == null) ? "Male" : this.gender;
    }

    /**
     * Sets the gender for the specified <code>String</code>
     * and fire a change property event
     * @param newGender A <code>String</code> for the student gender.
     */
    public void setGender(String newGender) {
        String oldGender = this.gender;
        this.gender = newGender;

        pcs.firePropertyChange("Gender", oldGender, newGender);
    }

    /**
     * Returns a <code>String</code> that represents the student's state of origin
     * @return state A <code>String</code> for the state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state to the specified <code>String</code>
     * @param state A <code>String</code> for the student state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns an <code>int</code> that represents the student's total score.
     * @return aggregate An <code>int</code> for the student's jamb aggregate.
     */
    public int getAggregate() {
        return aggregate;
    }

    /**
     * Sets the aggregate to the specified <code>int</code>
     * @param aggregate the aggregate to set
     */
    public void setAggregate(int aggregate) {
        this.aggregate = aggregate;
    }

    /**
     * Returns a <code>String</code> that represents the course that the student offers. 
     * @return courseName A <code>String</code> for the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name to the specified <code>String</code>
     * @param courseName A <code>String</code> for the student course name.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns a <code>String</code> that represents the students local government
     * of origin
     * @return the localGovernment
     */
    public String getLocalGovernment() {
        return localGovernment;
    }

    /**
     * Sets the local government to the specified <code>String</code>
     * @param localGovernment A <code>String</code> for the local government
     */
    public void setLocalGovernment(String localGovernment) {
        this.localGovernment = localGovernment;
    }

    @Override
    public String toString() {
        return "Student{" + "Jamb No: " + jambNo + ", First Name: " + firstName + ", Middle Name: " + middle + ", Last Name: " + lastName + ", Sex: "
                + gender + ", State: " + state + ", Aggregate: " + aggregate + ", Course Name: " + courseName + ", Local Government: " + localGovernment + '}';
    }

}
