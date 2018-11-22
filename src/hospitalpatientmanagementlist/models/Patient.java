/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.models;

/**
 *
 * @author rbsrafa
 */
public class Patient {
    private static int counter = 0;
    private final int PID;
    private final String ppsNumber;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String city;
    
    /**
     * Create a Patient with given arguments
     * @param ppsNumber
     * @param firstName
     * @param lastName
     * @param mobileNumber
     * @param email
     * @param city 
     */
    public Patient(String ppsNumber, String firstName, String lastName, String mobileNumber, String email, String city){
        this.PID = ++counter;
        this.ppsNumber = ppsNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
    }
    
    /**
     * Get a string representation of a patient
     * @return a patient representation
     */
    @Override
    public String toString(){
        return String.format("Patient \n PID: %s \n PPS Number: %s \n Name: %s %s \n Mobile Number: %s \n Email: %s \n City: %s\n", PID, ppsNumber, firstName, lastName, mobileNumber, email, city);
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPID() {
        return PID;
    }

    public String getPpsNumber() {
        return ppsNumber;
    }
    
}
