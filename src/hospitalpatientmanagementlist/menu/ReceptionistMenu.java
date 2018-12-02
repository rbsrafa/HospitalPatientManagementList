/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.menu;

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
    
    public ReceptionistMenu(){
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
            case 1: System.out.println("1");
                break;
            case 2: System.out.println("2");
                break;
            case 3: System.out.println("3");
                break;
            case 4: System.out.println("4");
                break;
            case 5: System.out.println("5");
                break;
            case 6: System.out.println("6");
                break;
            case 7: System.out.println("7");
                break;
            case 8: System.exit(0);
                break;
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
            "Get patient position",
            "Add patient to first position",
            "Add patient to last position",
            "Add patient to specific position",
            "Remove patient from list",
            "Remove last 'n' patients",
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
    
    public void displayMenu(){
        System.out.println("");
        System.out.println(this.title);
        for(int i = 0; i < this.title.length(); i++) System.out.print("-");
        System.out.println("");
        for(int i = 0; i < this.options.length; i++){
            System.out.println((i+1) + " - " + this.options[i]);
        }
    }

    
}
