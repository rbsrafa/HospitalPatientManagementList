package hospitalpatientmanagementlist.exceptions;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
 */
public class PatientNotFoundException extends RuntimeException{

    /**
     * Default contructor for PatientNotFoundException
     * @param id 
     */
    public PatientNotFoundException(int id) {
        super("Patient id " + id + " not found");
    }
    
}
