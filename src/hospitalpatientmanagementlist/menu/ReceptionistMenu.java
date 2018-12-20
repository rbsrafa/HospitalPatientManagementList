package hospitalpatientmanagementlist.menu;

import hospitalpatientmanagementlist.exceptions.EmptyListException;
import hospitalpatientmanagementlist.exceptions.PositionNotAvailableException;
import hospitalpatientmanagementlist.libraries.PatientList;
import hospitalpatientmanagementlist.mockData.PatientGenerator;
import hospitalpatientmanagementlist.models.Patient;
import hospitalpatientmanagementlist.validation.DataValidation;
import java.util.Scanner;

/**
 *
 * @author rbsrafa
 */
public class ReceptionistMenu {
    private String title;
    private String[] options;
    private boolean exit;
    private Scanner in;
    private DataValidation validate;
    private PatientList patientList;
    private boolean updating = false;
    
    /**
     * Initialise a new set of Patient objects and starts the Menu.
     */
    public ReceptionistMenu(){
        this.patientList = new PatientGenerator().generateList();
        this.validate = new DataValidation();
        this.in = new Scanner(System.in);
        this.title = "Reception Menu";
        this.setOptions();
        this.startMenu();
        
    }
    
    /**
     * Receives an int value that represents a Menu option and calls for 
     * the appropriated function.
     */
    public void optionSelector(){
        System.out.println("\nPlease select an option:");
        int option = this.validate.checkForInt(in);
        switch(option){
            case 1: 
                System.out.println("\nPatient List:\n");
                this.patientList.display();
                break;
            case 2: 
                this.updatePatientDetails();
                break;
            case 3:
                this.getPatientByPID();
                break;
            case 4:
                this.addFirst();
                break;
            case 5: 
                this.addToLastPosition();
                break;
            case 6: 
                this.addInPosition();
                break;
            case 7: 
                this.removePatient();
                break;
            case 8: 
                this.removeLastPatients();
                break;
            case 9: System.exit(0);
        }
    }
    
    /**
     * Initialise the Menu
     */
    public void startMenu(){
        while(!this.exit){
            this.displayMenu();
            this.optionSelector();
        }
    }
    
    /**
     * Define the options available for a Menu
     */
    public void setOptions(){
        String[] options = {
            "Show patient list",
            "Update patient details",
            "Get patient position",
            "Add patient to first position",
            "Add patient to last position",
            "Add patient to specific position",
            "Remove patient from list",
            "Remove last 'n' patients",
            "Exit program"
        };
        this.options = options;
    }
    
    /**
     * Add a Patient Object to the last position on the Patients List
     */
    private void addToLastPosition(){
        System.out.println(this.patientList.addLast(this.createNewPatient()));
    }
    
    /**
     * Remove n number of Patient Objects from the Patient List
     */
    private void removeLastPatients(){
        System.out.println("Please type the number of patients to remove");
        int number = this.validate.checkForInt(in);
        
        try{
            if(number > this.patientList.getSize()){
                System.out.println("\n*** Sorry, the select number is larger\n"
                        + "than the list size ***\n");
                removeLastPatients();
            }
            boolean patientRemoved = this.patientList.removeLastPatients(number);
            if(patientRemoved && number > 1){
                System.out.println("The last " + number + " patients were removed.");
            } else if (patientRemoved && number == 1) {
                System.out.println("The last patient was removed.");
            }
        }catch(EmptyListException e1){
            System.out.println("\n" + e1.getMessage() + "\n");
            removeLastPatients();
        }catch(PositionNotAvailableException e2){
            System.out.println("\n" + e2.getMessage() + "\n");
            removeLastPatients();
        }
    }
    
    /**
     * Removes a Patient object from the Patient List
     */
    private void removePatient(){
        System.out.println("Please type the patient PID");
        int PID = this.validate.checkForInt(in);
        if(PID > this.patientList.getSize() || PID < 1){
            System.out.println("\n*** Sorry this patient does not exist ***\n");
            this.removePatient();
        }
        boolean patientRemoved = this.patientList.removePatient(PID);
        if(patientRemoved){
            System.out.println("Patient PID: " + PID + " removed.");
        }
    }
    
    /**
     * Updates a Patient object details
     */
    private void updatePatientDetails(){
        this.updating = true;
        Patient toUpdate;
        
        System.out.println("Please type the patient PID");
        toUpdate = this.patientList.getPatient(this.validate.checkForInt(in));
        System.out.println("Patient to update:\n");
        System.out.println(toUpdate);
        System.out.println("");
        this.patientUpdateQuestions();
        
        while(updating){
            this.patientUpdateProperties(
                    this.selectPropertyToUpdate(), 
                    toUpdate
            );
        }
    }
    
    /**
     * 
     * @return 
     */
    private int selectPropertyToUpdate(){
        int option = this.validate.checkForInt(in);
            if(option < 1 || option > 7){
                System.out.println("\n*** Option not available, please try again ***\n");
            }
        return option;
    }
    
    /**
     * 
     * @param option
     * @param toUpdate 
     */
    private void patientUpdateProperties(int option, Patient toUpdate){
        this.patientUpdateQuestions();
        if(option == 1){
            System.out.println("Please type the new PPS number");
            toUpdate.setPpsNumber(this.validate.checkForString(in));
            this.patientUpdateQuestions();
        }else if(option == 2){
            System.out.println("Please type the first name");
            toUpdate.setFirstName(this.validate.checkForString(in));
            this.patientUpdateQuestions();
        }else if(option == 3){
            System.out.println("Please type the last name");
            toUpdate.setLastName(this.validate.checkForString(in));
            this.patientUpdateQuestions();
        }else if(option == 4){
            System.out.println("Please type the mobile number");
            toUpdate.setMobileNumber(this.validate.checkForString(in));
            this.patientUpdateQuestions();
        }else if(option == 5){
            System.out.println("Please type the email");
            toUpdate.setEmail(this.validate.checkForString(in));
            this.patientUpdateQuestions();
        }else if(option ==6){
            System.out.println("Please type the city");
            toUpdate.setCity(this.validate.checkForString(in));
            this.patientUpdateQuestions();
        }else if(option == 7){
            updating = false;
        }
    }
    
    /**
     * 
     */
    private void patientUpdateQuestions(){
        System.out.println("What you would like to update?\n"
                + "1 - PPS Number\n"
                + "2 - First Name\n"
                + "3 - Last Name\n"
                + "4 - Mobile Number\n"
                + "5 - Email\n"
                + "6 - City\n"
                + "7 - Done\n");
    }

    /**
     * Get information from user to create a new Patient
     */
    public Patient createNewPatient() {
        System.out.println("\nPlease inform patient PPS:");
        String pps = this.in.next();
        System.out.println("\nPlease inform patient First Name:");
        String firstName = this.in.next();
        System.out.println("\nPlease inform patient Last Name:");
        String lastName = this.in.next();
        System.out.println("\nPlease inform patient Mobile Number:");
        String mobileNumber = this.in.next();
        System.out.println("\nPlease inform patient email:");
        String email = this.in.next();
        System.out.println("\nPlease inform patient city:");
        String city = this.in.next();
        return new Patient(pps, firstName, lastName, mobileNumber, email, city);
        //System.out.println("pps "+pps+"\nf "+firstName+"\nl "+lastName+"\nn "+mobileNumber);
    }
    
    /**
     * Display the Menu options for the Patient List
     */
    public void displayMenu(){
        System.out.println("");
        System.out.println(this.title);
        for(int i = 0; i < this.title.length(); i++) System.out.print("-");
        System.out.println("");
        for(int i = 0; i < this.options.length; i++){
            System.out.println((i+1) + " - " + this.options[i]);
        }
    }
    
    /**
     * Asks user for a valid PID and fetch Patient position on the Patient List
     */
    public void getPatientByPID() {
        System.out.println("\nPlease inform patient PID:");
        int pidToFetch = this.validate.checkForInt(in);
        int patientPosition = this.patientList.getPositionByPID(pidToFetch);
        System.out.println("Patient current position is: " + patientPosition);
    }
    
    /**
     * Add a new Patient at the first position of the Patient List
     */
    public void addFirst() {
        System.out.println(this.patientList.addFirst(this.createNewPatient())); 
    }
    
    /**
     * Add a new Patient at specific position on the Patient List
     */
    public void addInPosition() {
        System.out.println("\nPlease inform position to add patient:");
        int position = this.validate.checkPosition(in, this.patientList.getSize());
        
        if(position == -1) {
            System.out.println("\n*** Invalid list position. Please try again ***");
            this.addInPosition();
        }
        
        this.patientList.addInPosition(this.createNewPatient(), position);
    }
}
