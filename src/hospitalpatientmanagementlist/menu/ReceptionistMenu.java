/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                System.out.println("1");
                break;
            case 2: 
                System.out.println("2");
                break;
            case 3: 
                System.out.println("\nPatient List:\n");
                this.patientList.display();
                break;
            case 4:
                this.getPatientByPID();
                break;
            case 5:
                this.addFirst();
                break;
            case 6: 
                System.out.println("6");
                break;
            case 7: 
                this.addInPosition();
                break;
            case 8: 
                System.out.println("8");
                break;
            case 9: 
                System.out.println("9");
                break;
            case 10: System.exit(0);
        }
    }
    
    public void startMenu(){
        this.displayWelcome();
        while(!this.exit){
            this.displayMenu();
            this.optionSelector();
        }
    }
    
    public void setOptions(){
        String[] options = {
            "Register new patient",
            "Update patient details",
            "Show patient list",
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
    
    public int chooseOption(){
        return 1;
    }
    
    public void displayWelcome(){
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
        this.patientList.addFirst(this.createNewPatient());
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
