package hospitalpatientmanagementlist.exceptions;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
 */
public class PositionNotAvailableException extends RuntimeException{

    /**
     * Default contructor for PositionNotAvailableException
     */
    public PositionNotAvailableException() {
        super("The given position is not available in the list. "
                + "\nThe position should be equal "
                + "or bigger than 1 and less or equal the list size.");
    }
    
}
