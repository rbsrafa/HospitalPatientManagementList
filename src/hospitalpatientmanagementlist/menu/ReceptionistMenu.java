package hospitalpatientmanagementlist.menu;

import hospitalpatientmanagementlist.exceptions.EmptyListException;
import hospitalpatientmanagementlist.exceptions.PatientNotFoundException;
import hospitalpatientmanagementlist.exceptions.PositionNotAvailableException;
import hospitalpatientmanagementlist.libraries.PatientList;
import hospitalpatientmanagementlist.mockData.PatientGenerator;
import hospitalpatientmanagementlist.models.Patient;
import hospitalpatientmanagementlist.validation.DataValidation;
import java.util.Scanner;

/**
 * @author 
 * rbsrafa
 * Lucival
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
     * Default constructor of ReceptionistMenu.
     */
    public ReceptionistMenu(){
        this.patientList = new PatientGenerator().generateList();
        this.validate = new DataValidation();
        this.in = new Scanner(System.in);
        this.title = "Reception Menu";
        this.setOptions();     
    }
    
    /**
     * Starts the menu. Displays all options on screen.
     */
    public void startMenu(){
        this.displayWelcome();
        while(!this.exit){
            this.displayMenu();
            this.optionSelector();
        }
    }
    
    /**
     * Activates the responsible functions related to the selected option.
     */
    private void optionSelector(){
        System.out.println("\nPlease select an option:");
        int option = this.validate.checkForInt(in);
        switch(option){
            case 1: this.showPatientList();
                break;
            case 2: this.updatePatientDetails();
                break;
            case 3: this.getPatientByPID();
                break;
            case 4: this.addFirst();             
                break;
            case 5: this.addToLastPosition();
                break;
            case 6: this.addInPosition();
                break;
            case 7: this.removePatient();
                break;
            case 8: this.removeLastPatients();
                break;
            case 9: System.exit(0);
        }
    }
    
    /**
     * Show all patients present on the patient list.
     */
    private void showPatientList(){
        System.out.println("\nPatient List:\n");
        this.patientList.display();
    }
    
    /**
     * Displays the hospital welcome logo.
     */
    private void displayWelcome(){
        System.out.println("  _____         _             _ \n" +
            "  \\_   \\  __ _ | |__    __ _ | |\n" +
            "   / /\\/ / _` || '_ \\  / _` || |\n" +
            "/\\/ /_  | (_| || |_) || (_| || |\n" +
            "\\____/   \\__, ||_.__/  \\__,_||_|\n" +
            "            |_|                 "
        );
        System.out.println("                            _  _           _ \n" +
            "  /\\  /\\  ___   ___  _ __  (_)| |_   __ _ | |\n" +
            " / /_/ / / _ \\ / __|| '_ \\ | || __| / _` || |\n" +
            "/ __  / | (_) |\\__ \\| |_) || || |_ | (_| || |\n" +
            "\\/ /_/   \\___/ |___/| .__/ |_| \\__| \\__,_||_|\n" +
            "                    |_|                      "
        );
    }
    
    /**
     * Set all available options on the menu.
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
     * Add a new patient to the last position of the list.
     */
    private void addToLastPosition(){
        System.out.println("\n" + this.patientList.addLast(this.createNewPatient()));
    }
    
    /**
     * Remove the last 'n' number of patients of the list.
     */
    private void removeLastPatients(){
        System.out.println("Please type the number of patients to remove");
        int number = this.validate.checkForInt(in);
        
        try{
            if(number > this.patientList.getSize()){
                System.out.println("\n*** Sorry, the select number is larger\n"
                        + "than the list size ***\n");              
            }
            boolean patientRemoved = this.patientList.removeLastPatients(number);
            if(patientRemoved && number > 1){
                System.out.println("The last " + number + " patients were removed.");
            } else if (patientRemoved && number == 1) {
                System.out.println("The last patient was removed.");
            }
        }catch(EmptyListException e1){
            System.out.println("\n" + e1.getMessage() + "\n");
            
        }catch(PositionNotAvailableException e2){
            System.out.println("\n" + e2.getMessage() + "\n");           
        }
    }
    
    /**
     * Removes a Patient object from the Patient List
     */
    private void removePatient(){
        System.out.println("Please type the patient PID");
        try{
            int PID = this.validate.checkForInt(in);
        if(PID > this.patientList.getSize() || PID < 1){
            System.out.println("\n*** Sorry this patient does not exist ***\n");
        }
        boolean patientRemoved = this.patientList.removePatient(PID);
        if(patientRemoved){
            System.out.println("Patient PID: " + PID + " removed.");
        }
        }catch(EmptyListException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Updates a Patient object details
     */
    private void updatePatientDetails(){
        this.updating = true;
        Patient toUpdate;
        
        System.out.println("Please type the patient PID");
        try{
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
        }catch(PatientNotFoundException e){
            System.out.println("\n" + e.getMessage() + "\n");
            this.updatePatientDetails();
        }
  
    }
    
    /**
     * Selects a Patient property to be updated. If the option is less than 1 or
     * greater than 7 displays a error message and prompt the user for a new try.
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
     * Prompt the user with the option to select which property to update.
     * @param option
     * @param toUpdate 
     */
    private void patientUpdateProperties(int option, Patient toUpdate){
        this.patientUpdateQuestions();
        if(option == 1){
            System.out.println("Please type the new PPS number");
            String pps = this.validate.checkForString(in);
            boolean valid = this.validate.checkForPPS(pps);
            if(valid) {
                toUpdate.setPpsNumber(pps);
                System.out.println("\nPPS Number successfully updated\n");
            }
            else System.out.println("\n*** Input is not a valid PPS number ***\n"
                    + "Please use the following format: 1234567LL\n");
            this.patientUpdateQuestions();
            
        }else if(option == 2){
            System.out.println("Please type the First Name");
            toUpdate.setFirstName(this.validate.checkForString(in));
            System.out.println("\nFirst Name successfully updated\n");
            this.patientUpdateQuestions();
            
        }else if(option == 3){
            System.out.println("Please type the Last Name");
            toUpdate.setLastName(this.validate.checkForString(in));
            System.out.println("\nLast Name successfully updated\n");
            this.patientUpdateQuestions();
            
        }else if(option == 4){
            System.out.println("Please type the Mobile Number");
            String mobileNumber = this.validate.checkForString(in);
            boolean valid = this.validate.checkMobileNumber(mobileNumber);
            if(valid) {
                toUpdate.setMobileNumber(mobileNumber);
                System.out.println("\nMobile number successfully updated\n");
            }
            else System.out.println("\n*** Invalid Mobile Number, it should have 10 digits without blanc spaces ***\n");
            this.patientUpdateQuestions();
            
        }else if(option == 5){
            System.out.println("Please type the Email");
            String email = this.validate.checkForString(in);
            boolean valid = this.validate.checkForEmail(email);
            if(valid) {
                toUpdate.setEmail(email);
                System.out.println("\nEmail successfully updated\n");
            }
            else System.out.println("\n*** Input is not a valid email ***\n");
            this.patientUpdateQuestions();
            
        }else if(option ==6){
            System.out.println("Please type the City");
            toUpdate.setCity(this.validate.checkForString(in));
            System.out.println("\nCity successfully updated\n");
            this.patientUpdateQuestions();
            
        }else if(option == 7){
            updating = false;
        }
    }
    
    /**
     * Display all available patient properties to update.
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
        boolean validPPS = false, validMobile = false, 
                validEmail = false;
        
        String pps = "", firstName = "", lastName = "", 
               mobileNumber = "", email = "", city = "";
        
        while(!validPPS) {
            System.out.println("\nPlease inform patient PPS:");
            pps = this.validate.checkForString(in);
            validPPS = this.validate.checkForPPS(pps);
            if(!validPPS) System.out.println("\n*** Input is not a valid PPS number ***\n"
                    + "Please use the following format: 1234567LL\n");
        }        
        
        System.out.println("\nPlease inform patient First Name:");
        firstName = this.validate.checkForString(in);
        
        System.out.println("\nPlease inform patient Last Name:");
        lastName = this.validate.checkForString(in);
        
        while(!validMobile){
            System.out.println("\nPlease inform patient Mobile Number:");
            mobileNumber = this.validate.checkForString(in);
            validMobile = this.validate.checkMobileNumber(mobileNumber);
            if(!validMobile) System.out.println("\n*** Invalid Mobile Number, "
                    + "it should have 10 digits without blanc spaces ***\n");
        }
        
        while(!validEmail){
            System.out.println("\nPlease inform patient email:");
            email = this.validate.checkForString(in);
            validEmail = this.validate.checkForEmail(email);
            if(!validEmail) System.out.println("\n*** Input is not a valid email ***\n");
        }
        
        System.out.println("\nPlease inform patient city:");
        city = this.validate.checkForString(in);
        
        return new Patient(pps, firstName, lastName, mobileNumber, email, city);
        
    }
    
    /**
     * Display all the available options of the Receptionist Menu.
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
        try{
            int patientPosition = this.patientList.getPositionByPID(pidToFetch);
            System.out.println("\nPatient current position is: " + patientPosition);
        }catch(PatientNotFoundException e){
            System.out.println("\n*** " + e.getMessage() + " ***");
            this.getPatientByPID();
        }
    }
    
    /**
     * Add a new Patient at the first position of the Patient List
     */
    public void addFirst() {
        System.out.println("\n" + this.patientList.addFirst(this.createNewPatient())); 
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
        
        try{
            this.patientList.addInPosition(this.createNewPatient(), position);
        }catch(PositionNotAvailableException e){
            System.out.println("\n" + e.getMessage());
            this.addInPosition();
        }
        
    }
}
