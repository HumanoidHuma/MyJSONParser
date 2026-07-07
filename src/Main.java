import my.JSONParser;

public class Main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        // 1
        Box box = new Box("Simple Box", 1234567890, "Ilia");

        String parsedJson = parser.parse(box);
        System.out.println(parsedJson);
        // 2
        Box box2 = new Box("GIGA BOX", 99999);
        parsedJson = parser.parse(box2);
        System.out.println(parsedJson);
        // 3
        Box box3 = new Box(110011);
        parsedJson = parser.parse(box3);
        System.out.println(parsedJson);

        System.out.println();
        System.out.println();
        System.out.println();

        Box<Integer> rabbitBox = new Box<>("SECRET BOX", 1024, "Markar");
        Rabbit rabbit = new Rabbit("Markar", rabbitBox);
        parsedJson = parser.parse(rabbit);
        System.out.println(parsedJson);
    }
}