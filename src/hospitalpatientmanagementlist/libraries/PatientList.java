/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.libraries;

import hospitalpatientmanagementlist.exceptions.EmptyListException;
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
        this.first = null;
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
        if(this.isEmpty()) System.out.println(new EmptyListException().getMessage());  
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
        if(this.isEmpty()) throw new EmptyListException();
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
        if(this.isEmpty()) return this.addFirst(patient);
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
     * Add the given patient in the given position in the list.
     * If position is not available throw a PositionNotAvailableException.
     * @param patient
     * @param position
     * @return the patient added in the list 
     */
    @Override
    public Patient addInPosition(Patient patient, int position) {
        Node inserted = null;
        
        if(position == 1) return this.addFirst(patient);
        else if(this.isEmpty() && position > 1) throw new PositionNotAvailableException();
        else if(this.size + 1 == position) return this.addLast(patient);
        else{
            Node temp = this.getNode(position);      
            Node before = this.getNode(position-1);
            inserted = new Node(patient, temp);
            before.setNext(inserted);
            ++size;
        }
        return inserted.getPatient();
    }
    
    /**
     * Get the size of the list
     * @return list size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Get the node in the given position. If the list is empty throw 
     * EmptyListException, if the position is not available throw 
     * PositionNotAvailableException.
     * @param position
     * @return the node in the given position 
     */
    private Node getNode(int position){
        if(this.isEmpty()) throw new EmptyListException();
        else if(position <=0 || position > this.size) throw new PositionNotAvailableException();
        Node current = this.first;
        Node node = null;
        int pos = 1;
        while(current != null){
            if(position == pos) node = current;
            ++pos;
            current = current.getNext();
        }
        return node;
    }
    
    /**
     * Get the last node in the list. If the list is empty throw
     * a EmptyListException.
     * @return the last node in the list 
     */
    private Node getLastNode(){
        if(this.isEmpty()) throw new EmptyListException();
        Node current = this.first;
        Node last = null;
        while(current != null){
            if(current.getNext() == null) last = current;
            current = current.getNext();
        }
        return last;
    }
    
    /**
     * Remove a patient by PID. If list is empty throw EmptyListException.
     * @param PID
     * @return true if removed or false otherwise
     */
    @Override
    public boolean removePatient(int PID) {
        // If list is empty
        if(this.isEmpty()) throw new EmptyListException();        
        // If first node match
        if(this.first.getPatient().getPID() == PID){
            return this.removeFirst();
        }
        
        // Start searching from second node
        Node current = this.first.getNext();
        // Keep track of previous node
        Node prev = this.first;
        while(current != null){
            // If PID matches set the previous node's next to current's next.
            if(current.getPatient().getPID() == PID){ 
                prev.setNext(current.getNext());
                --size;
                return true;
            }
            prev = current;
            current = current.getNext();
        }
        return false;
    }
    
    private boolean removeFirst(){
        if(this.isEmpty()) throw new EmptyListException();
        this.first = this.first.getNext();
        --size;
        return true;
    }
    
    /**
     * Remove n patients from the end of the list. 
     * If list is empty throw EmptyListException.
     * @param range
     * @return true if removed or false otherwise
     */
    @Override
    public boolean removeLastPatients(int range) {
        int deletionPoint = this.getSize() - range;
        if(deletionPoint < 0) throw new PositionNotAvailableException();
        else if (deletionPoint == 0) {
            this.first = null;
            this.size -= range;
            return true;}
        else {
            this.getNode(deletionPoint).setNext(null);
            this.size -= range;
            return true;
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
    public Patient updatePatientInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
}
