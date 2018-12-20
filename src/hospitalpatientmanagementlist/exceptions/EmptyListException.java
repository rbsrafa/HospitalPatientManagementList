package hospitalpatientmanagementlist.exceptions;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
 */
public class EmptyListException extends RuntimeException{

    public EmptyListException() {
        super("Patient list is empty");
    }
    
}
