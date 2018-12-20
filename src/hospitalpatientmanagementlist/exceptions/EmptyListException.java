package hospitalpatientmanagementlist.exceptions;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
 */
public class EmptyListException extends RuntimeException{

    /**
     * Default contructor for EmptyListException
     */
    public EmptyListException() {
        super("Patient list is empty");
    }
    
}
