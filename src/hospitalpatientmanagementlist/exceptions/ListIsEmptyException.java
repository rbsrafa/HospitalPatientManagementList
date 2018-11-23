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
public class ListIsEmptyException extends RuntimeException{

    public ListIsEmptyException() {
        super("Patient list is empty");
    }
    
}
