package hospitalpatientmanagementlist;

import hospitalpatientmanagementlist.menu.ReceptionistMenu;

/**
 *
 * @authors 
 * rbsrafa
 * Lucival
 */
public class HospitalPatientManagementList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creates a new Receptionist Menu
        ReceptionistMenu menu = new ReceptionistMenu();
        // Initializes the Receptionist Menu
        menu.startMenu();
    } 
}
