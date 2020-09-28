package Lab8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab8 {

    public Lab8() {
        try {
            FileWriter writer = new FileWriter("Lab8/file.txt", true);
            String text =
                    "\nda kto takie vashi bipki?\n" +
                    "A?\n" +
                    "Ty komu zvonish?";
            writer.write(text);
            writer.flush();
            writer.close();
            FileReader reader = new FileReader("Lab8/file.txt");
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Lab8 lab8 = new Lab8();
    }
}
