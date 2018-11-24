/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist;

import hospitalpatientmanagementlist.libraries.Node;
import hospitalpatientmanagementlist.libraries.PatientList;
import hospitalpatientmanagementlist.mockData.PatientGenerator;
import hospitalpatientmanagementlist.models.Patient;

/**
 *
 * @author rbsrafa
 */
public class HospitalPatientManagementList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PatientList patientList = new PatientList();
        Patient[] patients = new PatientGenerator().generatePatients();
        
        Node[] nodes = new Node[6];
        for(int i = 0; i < patients.length; i++){
            nodes[i] = new Node(patients[i]);
        }

        patientList.addFirst(patients[0]);
        patientList.addLast(patients[1]);
        patientList.addLast(patients[2]);
        patientList.addLast(patients[3]);
        patientList.addLast(patients[4]);
        patientList.addLast(patients[5]);

        // remove patients by PID
        try{
            System.out.println(patientList.removePatient(6)); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        // remove last n patients of the list
        try{
            System.out.println(patientList.removeLastPatients(5));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
        
        
        
        patientList.display();
        System.out.println(patientList.getSize());
    }
    
}
