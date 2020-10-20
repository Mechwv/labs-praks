package praktika.Prak14;

import java.util.ArrayList;

public class Shirt {
    private String id;
    private String type;
    private String color;
    private String size;

    public Shirt(String id, String type, String color, String size) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shirt" + "\n" +
                "    id: " + id + "\n" +
                "    type: " + type + "\n" +
                "    color: " + color + "\n" +
                "    size: " + size + "\n";
    }


    public static void main(String[] args) {
        String[] shirts =
                {"S001,Black Polo Shirt,Black,XL"
                        ,"S002,Black Polo Shirt,Black,L"
                        ,"S003,Blue Polo Shirt,Blue,XL"
                        ,"S004,Blue Polo Shirt,Blue,M"
                        ,"S005,Tan Polo Shirt,Tan,XL"
                        ,"S006,Black T-Shirt,Black,XL"
                        ,"S007,White T- Shirt,White,XL"
                        ,"S008,White T-Shirt,White,L"
                        ,"S009,Green T-Shirt,Green,S"
                        ,"S010,Orange T-Shirt,Orange,S"
                        ,"S011,Maroon Polo Shirt,Maroon,S"
                };
        String[] buffer;
        ArrayList<Shirt> arrayList = new ArrayList<>(shirts.length);
        for (String a : shirts) {
            buffer = a.split(",");
            Shirt shirt = new Shirt(buffer[0], buffer[1], buffer[2], buffer[3]);
            arrayList.add(shirt);
        }
        for (Shirt a : arrayList){
            System.out.println(a.toString());
        }
    }
}
