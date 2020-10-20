package Lab13;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "((?=^.{8,}$)(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])([^_]*))";
        Pattern money = Pattern.compile(regex);
        Matcher matcher = money.matcher(input);
        if (matcher.find()) {
            System.out.print("OK");
        }

    }
}
