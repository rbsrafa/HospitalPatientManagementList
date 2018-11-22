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
public class PatientList implements INode{
    private Node first;
    private int size;
    
    /**
     * Create a empty patient list
     */
    public PatientList(){
        this.size = 0;
    }
    
    /**
     * Create a patient list with a given node
     * @param first 
     */
    public PatientList(Node first){
        this.first = first;
        this.size = 1;
    }
    
    /**
     * Check if the list is empty.
     * @return true if list is empty and false otherwise. 
     */
    public boolean isEmpty(){
        if(this.size == 0) return true;
        else return false;
    }
    
    /**
     * Print the entire list of patients.
     */
    public void display(){     
        Node current = this.first;
        // Print a message if the list is empty
        if(this.isEmpty()) System.out.println("Patient list is empty");
        else {
            // Iterate over list and print each patient
            while(current != null){
                System.out.println(current.getPatient());
                current = current.getNext();
            }
        }
    }

    @Override
    public int getPositionByName(String first, String last) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPositionByPID(int PID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Patient addLast(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Patient addInPosition(Patient patient, int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removePatient(int PID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Add a given patient as the first of the list, if the list is not
     * empty, set the old first patient as second of the list.
     * @param patient
     * @return the new first patient in the list
     */
    @Override
    public Patient addFirst(Patient patient) {
        // If list is empty set the given patient as first
        if(this.first == null) this.first = new Node(patient);
        else{
            // Copy first node in memory
            Node temp = this.first;
            // Set new patient as first node
            this.first = new Node(patient);
            // Set old first as the next of new first node
            this.first.setNext(temp);
        }
        // Increase list size
        this.size++;
        // return new first patient
        return this.first.getPatient();
    }

    @Override
    public boolean removeLastPatients(int range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Patient updatePatientInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Get the first node of the list
     * @return the first node
     */
    public Node getFirst() {
        return first;
    }

    /**
     * Get the size of the list
     * @return list size
     */
    public int getSize() {
        return size;
    }    
    
}
