package Lab12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "(^[0-9]+\\.?[0-9]*\\s(?:USD|RUB|EUR)$)";
        Pattern money = Pattern.compile(regex);
        Matcher matcher = money.matcher(input);
        while (matcher.find()) {
            System.out.println("currency: " + matcher.group());
        }
    }
}
