import com.sun.jdi.IntegerType;

public class Box<T> {
    public String boxName;
    public T value;
    public String ownerName;

    private String secreteMessage = "THIS IS A SECRET MESSAGE!!!";

    public Box(String boxName, T value, String ownerName) {
        this.boxName = boxName;
        this.value = value;
        this.ownerName = ownerName;
    }

    public Box(String boxName, T value) {
        this.boxName = boxName;
        this.value = value;
    }

    public Box(T value) {
        this.value = value;
    }
}