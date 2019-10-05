package oracle.ocp.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Block {
    String color;
    Integer size;
    public Block(String color, Integer size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Block{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}

class ColorSortingDeviceTwo implements Comparator<Block> {
    @Override
    public int compare(Block o1, Block o2) {
        return o1.color.compareTo(o2.color);
    }
}

public class SortOfFun {
    public static void main(String[] args) {
        List<Block> list = Arrays.asList(
                new Block("Rdled", 10),
                new Block("Bdlue", 20),
                new Block("Whiolette", 54));
        Collections.sort(list, new ColorSortingDeviceTwo());
        System.out.println(list);
    }
}
