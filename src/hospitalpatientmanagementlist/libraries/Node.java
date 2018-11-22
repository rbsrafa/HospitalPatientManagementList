/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.libraries;

import hospitalpatientmanagementlist.models.Patient;

/**
 *
 * @author rbsrafa
 */
public class Node {
    Patient patient;
    Node next;
    
    public Node(Patient patient, Node next){
        this.patient = patient;
        this.next = next;
    }
    
    public Node(Patient patient){
        this(patient, null);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}
