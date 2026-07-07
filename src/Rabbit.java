public class Rabbit {
    public String rabbitName;
    public Box<?> rabbitBox;

    public Rabbit(String name, Box<?> box) {
        rabbitName = name;
        rabbitBox = box;
    }
}