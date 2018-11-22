/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.mockData;

import hospitalpatientmanagementlist.models.Patient;

/**
 *
 * @author rbsrafa
 */
public class PatientGenerator {
    
    public PatientGenerator(){}
    
    public Patient[] generatePatients(){        
        String[] ppsNumbers = {"12345678W", "87654321W", "56974268W", "71320158W", "52671087W", "54036974W"};
        String[] firstNames = {"John", "Louis", "Peter", "Sara", "Lucy", "Mary"};
        String[] lastNames = {"Smith", "Wood", "Acton", "Windsor", "Clifford", "Holton"};
        String[] mobileNumbers = {"0899739212", "0837419547", "0873214589", "0896214533", "0871234569", "0831478520"};
        String[] emails = {"john@gmail.com", "louis@gmail.com", "peter@yahoo.com", "sara@hotmail.com", "lucy@gmail.com", "mary@hotmail.com"};
        String[] cities = {"London", "Dublin", "Galway", "Bray", "Greystones", "Wicklow"};
    
        Patient[] patients = new Patient[6];
        for(int i = 0; i < ppsNumbers.length; i++){
            patients[i] = new Patient(ppsNumbers[i], firstNames[i], lastNames[i], mobileNumbers[i], emails[i], cities[i]);
        }
        
        return patients;
    }
    
}
