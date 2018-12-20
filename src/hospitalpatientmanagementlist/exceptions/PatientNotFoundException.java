package hospitalpatientmanagementlist.exceptions;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
 */
public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException(int id) {
        super("Patient id " + id + " not found");
    }
    
}
