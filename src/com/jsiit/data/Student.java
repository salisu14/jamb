/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsiit.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
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

    public Student() {
    }

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
     * @return the jambNo
     */
    public String getJambNo() {
        return jambNo;
    }

    /**
     * @param jambNo the jambNo to set
     */
    public void setJambNo(String jambNo) {
        this.jambNo = jambNo;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middle
     */
    public String getMiddle() {
        return middle;
    }

    /**
     * @param middle the middle to set
     */
    public void setMiddle(String middle) {
        this.middle = middle;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return (gender == null) ? "Male" : this.gender;
    }

    /**
     * @param newGender the gender to set
     */
    public void setGender(String newGender) {
        String oldGender = this.gender;
        this.gender = newGender;

        pcs.firePropertyChange("Gender", oldGender, newGender);
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the aggregate
     */
    public int getAggregate() {
        return aggregate;
    }

    /**
     * @param aggregate the aggregate to set
     */
    public void setAggregate(int aggregate) {
        this.aggregate = aggregate;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the localGovernment
     */
    public String getLocalGovernment() {
        return localGovernment;
    }

    /**
     * @param localGovernment the localGovernment to set
     */
    public void setLocalGovernment(String localGovernment) {
        this.localGovernment = localGovernment;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Student{" + "Jamb No: " + jambNo + ", First Name: " + firstName + ", Middle Name: " + middle + ", Last Name: " + lastName + ", Sex: "
                + gender + ", State: " + state + ", Aggregate: " + aggregate + ", Course Name: " + courseName + ", Local Government: " + localGovernment + '}';
    }

}
