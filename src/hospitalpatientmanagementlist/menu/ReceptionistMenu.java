package hospitalpatientmanagementlist.menu;

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
    
    public ReceptionistMenu(){
        this.patientList = new PatientGenerator().generateList();
        this.validate = new DataValidation();
        this.in = new Scanner(System.in);
        this.title = "Reception Menu";
        this.setOptions();
        this.startMenu();
        
    }
    
    public void optionSelector(){
        System.out.println("\nPlease select an option:");
        int option = this.validate.checkForInt(in);
        switch(option){
            case 1: 
                System.out.println("\nPatient List:\n");
                this.patientList.display();
                break;
            case 2: 
                System.out.println("bla"); 
                break;
            case 3:
                this.getPatientByPID();
                break;
            case 4:
                this.addFirst();
                break;
            case 5: 
                System.out.println("6");
                break;
            case 6: 
                this.addInPosition();
                break;
            case 7: 
                System.out.println("8");
                break;
            case 8: 
                System.out.println("9");
                break;
            case 9: System.exit(0);
        }
    }
    
    public void startMenu(){
        while(!this.exit){
            this.displayMenu();
            this.optionSelector();
        }
    }
    
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
    
    private void updatePatientDetails(){

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
