package hospitalpatientmanagementlist.libraries;

import hospitalpatientmanagementlist.exceptions.EmptyListException;
import hospitalpatientmanagementlist.exceptions.PositionNotAvailableException;
import hospitalpatientmanagementlist.exceptions.PatientNotFoundException;
import hospitalpatientmanagementlist.models.Patient;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
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
     * @return the new first Patient in the list
     */
    @Override
    public Patient addFirst(Patient patient) {
        this.first = new Node(patient, this.first);
        this.size++;
        return this.first.getPatient();
    }
    
    /**
     * Gets the first Patient object from the Patient List
     * @return the first Patient object on the List
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
    
    /**
     * Removes the first Patient from the Patient List.
     * If list is empty throw EmptyListException.
     * @return true if removed or false otherwise
     */
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
        // Define the position where the deletion happens
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

    /**
     * Get the actual Patient position based in the first and last name.
     * If list is empty throw EmptyListException.
     * If name it is not in the list throw PatientNotFoundException.
     * @param first
     * @param last
     * @return the patient position when found otherwise returns -1
     */
    @Override
    public int getPositionByName(String first, String last) {
        // Start searching from first node
        Node current = this.first;
        // Start in the first position
        int position = 1;
        while(current != null){
            // if current Patient name matches with the one passed in the argument
            // returns the position
            if(current.getPatient().getFirstName() == first 
                    && current.getPatient().getLastName() == last) {
                return position;
            }
            // increase position counter and gets next Patient
            position++;
            current = current.getNext();
        }
        // Error returns position -1
        throw new PatientNotFoundException(-1);
    }
    
    /**
     * Get the actual Patient position based in the PID.
     * If list is empty throw EmptyListException.
     * If name it is not in the list throw PatientNotFoundException.
     * @param PID
     * @return the Patient object position when found otherwise returns -1
     */
    @Override
    public int getPositionByPID(int PID) {
        // Start searching from first node
        Node current = this.first;
        // Start in the first position
        int position = 1;
        while(current != null){
            // if current Patient PID matches with the PID returns the position
            if(current.getPatient().getPID() == PID) {
                return position;
            }
            // increase position counter and gets next Patient
            position++;
            current = current.getNext();
        }
        // Error returns PID not found
        throw new PatientNotFoundException(PID);
    }
 
    /**
     * Gets a Patient from the Patient List using the PID value
     * @param PID
     * @return a Patient object
     */
    @Override
    public Patient getPatient(int PID) {
        int position = this.getPositionByPID(PID);
        Patient p = this.getNode(position).getPatient();
        return p;
    }   
    
}
