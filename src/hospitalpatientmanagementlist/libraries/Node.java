package hospitalpatientmanagementlist.libraries;

import hospitalpatientmanagementlist.models.Patient;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
 */
public class Node {
    private Patient patient;
    private Node next;
    
    /**
     * Create a node with a given patient and next node 
     * @param patient
     * @param next 
     */
    public Node(Patient patient, Node next){
        this.patient = patient;
        this.next = next;
    }
    
    /**
     * Create a node with a given patient
     * @param patient 
     */
    public Node(Patient patient){
        this(patient, null);
    }

    /**
     * Get the node's patient
     * @return a patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Set the node's patient
     * @param patient 
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Get the next node
     * @return next node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Set the next node
     * @param next 
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
}
