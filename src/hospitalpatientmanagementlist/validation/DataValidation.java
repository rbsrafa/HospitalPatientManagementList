package hospitalpatientmanagementlist.validation;

/**
 *
 * @author 
 * rbsrafa
 * Lucival
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains methods used to validate user input such as int,
 * int within defined range, String and date.
 * @author Gustavo Lessa
 * @author Rafael Barros
 */
public class DataValidation {
    
    /**
     * This method checks if the input is a valid mobile number.
     * @param mobile
     * @return A validated mobile number
     */
    public boolean checkMobileNumber(String mobile){
        Matcher matcher = Pattern.compile(
                "^[0-9]{10}$", 
                Pattern.CASE_INSENSITIVE
        ).matcher(mobile);
        
        if(matcher.find()) return true;
        else return false;
    }
    
    /**
     * This method checks if the input is a valid email format.
     * @param email
     * @return A validated email
     */
    public boolean checkForEmail(String email){
        Matcher matcher = Pattern.compile(
                "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 
                Pattern.CASE_INSENSITIVE
        ).matcher(email);
        
        if(matcher.find()) return true;
        else return false;
    }
    
    /**
     * This method checks if the input is a valid PPS format.
     * @param pps
     * @return A validated PPS number
     */
    public boolean checkForPPS(String pps){
        Matcher matcher = Pattern.compile(
                "^\\d{7}?[A-Z]{1,2}$", 
                Pattern.CASE_INSENSITIVE
        ).matcher(pps);
        
        if(matcher.find()) return true;
        else return false;
    }
    
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
 
}