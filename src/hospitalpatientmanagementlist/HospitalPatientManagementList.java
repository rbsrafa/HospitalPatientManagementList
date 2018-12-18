/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist;

import hospitalpatientmanagementlist.menu.ReceptionistMenu;


/**
 *
 * @author rbsrafa
 */
public class HospitalPatientManagementList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        displayWelcome();
        ReceptionistMenu menu = new ReceptionistMenu();
    }
    
    public static void displayWelcome(){
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
    
}
