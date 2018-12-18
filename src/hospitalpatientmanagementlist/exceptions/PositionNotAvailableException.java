/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.exceptions;

/**
 *
 * @author rbsrafa
 */
public class PositionNotAvailableException extends RuntimeException{

    public PositionNotAvailableException() {
        super("The given position is not available in the list. "
                + "\nThe position should be equal "
                + "or bigger than 1 and less or equal the list size.");
    }
    
}
