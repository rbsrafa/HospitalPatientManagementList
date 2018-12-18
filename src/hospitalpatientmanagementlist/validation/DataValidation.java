/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalpatientmanagementlist.validation;

/**
 *
 * @author rbsrafa
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains methods used to validate user input such as int,
 * int within defined range, String and date.
 * @author Gustavo Lessa
 * @author Rafael Barros
 */
public class DataValidation {
    
    
    /**
     * This method checks if the input is a integer.
     * @param input (Scanner)
     * @return A validated int
     */
    public int checkForInt(Scanner input){
        try{return input.nextInt();}
        catch(InputMismatchException e){
            input.next();
            System.out.println("\n*** Input is not a integer. Please try again. ***\n");
            return checkForInt(input);
        }
    }
    
    /**
     * This method checks the user input against the list size.
     * @param input (Scanner)
     * @return A validated int
     */
    public int checkPosition(Scanner input, int listSize){
        int validInt = this.checkForInt(input);
        if(validInt > listSize){return -1;}
        return validInt;
    }
    
    /**
     * This method returns a whole line input by the user.
     * @param input (Scanner)
     * @return The input String
     */
    public String checkForString(Scanner input){
        String ans = "";
        while(ans.isEmpty()){
            try{
               ans = input.nextLine();}
            catch(InputMismatchException e){
               System.out.println("\n*** Input not valid. Please try again. ***\n");
               return checkForString(input);
            }           
        }
        return ans;
    }
 
    /**
     * This method checks for a positive answer from user.
     * @param input (Scanner)
     * @return true if the input is 'Y' or 'y' and false otherwise
     */
    public boolean checkForYes(Scanner input) throws InputMismatchException{
        String answer = "";
        try{
            while(answer.isEmpty()){
                answer = input.nextLine();
            }
            if(answer.startsWith("y") || answer.startsWith("Y")){
                return true;
            } else if ((answer.startsWith("n") || answer.startsWith("N"))){
                return false;
            } else {
                throw new InputMismatchException();
            }
            } catch(InputMismatchException e){
            System.out.println("\n*** Input not identified. Please try again. ***\n");
            return checkForYes(input);
        }
    }
    
    /**
     * This method checks for a integer input between a specific boundary.
     * @param input (Scanner)
     * @param lowerBoundary (int)
     * @param upperBoundary (int)
     * @return A validated integer between the specified boundary.
     */
    public int checkForInt(Scanner input, int lowerBoundary, int upperBoundary){
        int typedInt = 0;
        try{
            while(typedInt == 0){
                typedInt = input.nextInt();
            }
            if(typedInt>=lowerBoundary && typedInt<=upperBoundary){
                return typedInt;
            }else{
                System.out.println("\n*** The option should be and integer between "+
                        lowerBoundary+" and "+upperBoundary+". ***\n");
                System.out.println("Please try again:");
                return checkForInt(input, lowerBoundary,upperBoundary);
            }
        } catch(InputMismatchException e){
            System.out.println("\n*** Input is not an integer. ***\nPlease try again.\n");
            input.nextLine();
            return checkForInt(input, lowerBoundary,upperBoundary);
        }
    }
    
    /**
     * This method formats a raw string into a date format.
     * @param input (Scanner)
     * @return A formated date String
     */
    public Date checkForDate(Scanner input){ 
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        fmt.setLenient(false);
        String typedDate = "";
        try {
            while(typedDate.isEmpty()){
                typedDate = input.nextLine();   
            }
            Date correctDate = fmt.parse(typedDate);
            return correctDate;
        } catch (ParseException e) {
            System.out.println("Wrong format! Date should be DD/MM/YYYY. Try again.");
            return checkForDate(input);
        }
    }
}
