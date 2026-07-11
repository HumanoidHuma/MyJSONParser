import my.JSONParser;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        JSONParser parser = new JSONParser();
        // 1
        Box box = new Box("Simple Box", 1234567890, "Ilia");

        String parsedJson = parser.serialize(box);
        System.out.println(parsedJson);
        // 2
        Box box2 = new Box("GIGA BOX", 99999);
        parsedJson = parser.serialize(box2);
        System.out.println(parsedJson);
        // 3
        Box box3 = new Box(110011);
        parsedJson = parser.serialize(box3);
        System.out.println(parsedJson);

        System.out.println();
        System.out.println();
        System.out.println();

        Box<Integer> rabbitBox = new Box<>("SECRET BOX", 1024, "Markar");
        Rabbit rabbit = new Rabbit("Markar", rabbitBox);
        parsedJson = parser.serialize(rabbit);
        System.out.println(parsedJson);

        System.out.println();
        Set<Class<?>> hashedClass = JSONParser.getHashedClass();
        for (Class<?> clazz : hashedClass) {
            System.out.println(clazz);
        }
    }
}