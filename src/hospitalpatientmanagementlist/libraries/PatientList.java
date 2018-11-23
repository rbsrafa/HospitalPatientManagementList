/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.libraries;

import hospitalpatientmanagementlist.exceptions.ListIsEmptyException;
import hospitalpatientmanagementlist.exceptions.PositionNotAvailableException;
import hospitalpatientmanagementlist.models.Patient;

/**
 *
 * @author rbsrafa
 */
public class PatientList implements INode{
    private Node first;
    private int size;
    
    //   CONSTRUCTORS   //
    
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
    
    //   METHODS   //
    
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
        if(this.isEmpty()) System.out.println(new ListIsEmptyException().getMessage());  
        else {
            int position = 0;
            // Iterate over list and print each patient
            while(current != null){
                ++position;
                System.out.println("Patient " + Integer.toString(position) + "\n----------\n" + current.getPatient());
                current = current.getNext();
            }
        }
    }
    
    /**
     * Add a given patient as the first of the list, if the list is not
     * empty, set the old first patient as second of the list.
     * @param patient
     * @return the new first patient in the list
     */
    @Override
    public Patient addFirst(Patient patient) {
        this.first = new Node(patient, this.first);
        this.size++;
        return this.first.getPatient();
    }
    
    /**
     * Get the first node of the list
     * @return the first node
     */
    public Patient getFirst() {
        return first.getPatient();
    }
    
    /**
     * Add a patient to the end of the list. If the list is empty
     * add the given patient as the first.
     * @param patient
     * @return the added patient 
     */
    @Override
    public Patient addLast(Patient patient) {
        this.getLastNode().setNext(new Node(patient));
        ++size;
        return this.getLast();
    }
    
    /**
     * Get the last patient in the list.
     * @return the last patient
     */
    public Patient getLast(){
        return this.getLastNode().getPatient();
    }
    
    /**
     * Get the size of the list
     * @return list size
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the last node in the list. If the list is empty throw
     * a ListIsEmptyException.
     * @return the last node in the list 
     */
    private Node getLastNode(){
        if(this.isEmpty()) throw new ListIsEmptyException();
        Node current = this.first;
        Node last = null;
        while(current != null){
            if(current.getNext() == null) last = current;
            current = current.getNext();
        }
        return last;
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
    public boolean removePatient(int PID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * Add the given patient in the given position in the list.
     * If position is not available throw a PositionNotAvailableException.
     * @param patient
     * @param position
     * @return the patient added in the list 
     */
    @Override
    public Patient addInPosition(Patient patient, int position) {
        // add the given patient in position 2
        if(position <= 0 || position > this.size) throw new PositionNotAvailableException();
        else if(position == 1) this.addFirst(patient);
        else{
            Node current = this.first;
            Node temp = null;
            int pos = 1;
            while(current != null){
                
            }
        }        
        
        return patient;
    }

    
    
    

    


        
    
}
