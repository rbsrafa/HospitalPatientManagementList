/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist;

import hospitalpatientmanagementlist.libraries.Node;
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
        Patient[] patients = new PatientGenerator().generatePatients();
        
        Node[] nodes = new Node[6];
        for(int i = 0; i < patients.length; i++){
            nodes[i] = new Node(patients[i]);
        }
        
        for(Node n : nodes) System.out.println(n.getPatient()); 
        
    }
    
}
