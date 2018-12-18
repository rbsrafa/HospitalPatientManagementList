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
    private String ppsNumber;
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
        return String.format("PID: %s \nPPS Number: %s \nName: %s %s \nMobile Number: %s \nEmail: %s \nCity: %s\n", PID, ppsNumber, firstName, lastName, mobileNumber, email, city);
    }

    /**
     * Get the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the mobile number
     * @return the mobile number
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Set the mobile number
     * @param mobileNumber 
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Get the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the city
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the patient id
     * @return the PID
     */
    public int getPID() {
        return PID;
    }

    /**
     * Get the pps number
     * @return the ppsNumber
     */
    public String getPpsNumber() {
        return ppsNumber;
    }
    
    /**
     * Set the PPS number
     * @param pps 
     */
    public void setPpsNumber(String pps){
        this.ppsNumber = pps;
    }
}
