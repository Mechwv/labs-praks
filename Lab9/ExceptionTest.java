package Lab9;

import java.util.Scanner;

public class ExceptionTest {
    public static void getKey() {
        Scanner myScanner = new Scanner( System.in );
        String key = myScanner.nextLine();
        try {
            printDetails( key );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printDetails(String key) throws Exception {
        try { String message = getDetails(key);
            System.out.println( message );
        }catch ( Exception e){
            throw e;
        }
    }
    private static String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception(" Key set to empty string ");
        }
        return " data for " + key;
    }

    public static void exceptionDemo(){
            Scanner myScanner = new Scanner(System.in);
            System.out.print("Enter integers ");
            for (int k=0; k < 4; k++) {
                try {
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
                    System.out.println("attempts: "+k);
                }
            }
            getKey();
    }



    public static void main(String[] args) {
        exceptionDemo();
    }
}
