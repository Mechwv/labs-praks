package Lab9;

import java.util.Scanner;

public class ExceptionTest {
    public static void exceptionDemo(){
        try {
            Scanner myScanner = new Scanner(System.in);
            System.out.print("Enter an integer ");
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }
        catch (NumberFormatException number){
            System.out.println("This is not an integer");
        }
        catch (ArithmeticException arithm){
            System.out.println("Division by zero");
        }
        finally {
            System.out.println("I will be printed 100%");
        }

    }
    public void printDetails(String key) throws Exception {
        try { String message = getDetails(key);
            System.out.println( message );
        }catch ( Exception e){
            throw e;
        }
    }
    private String getDetails(String key) throws Exception {
        if (key.equals("")){
            throw new Exception( " Key set to empty string " );
        }

        return " data for " + key;
    }

    public static void main(String[] args) {
        exceptionDemo();
    }
}
