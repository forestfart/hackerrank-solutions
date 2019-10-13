package oracle.ocp.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerCheckOnHashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2,20);
        BiConsumer<Integer, Integer> biConsumer = (i, j) -> {System.out.print (i + "," + j + "; ");};
        biConsumer.accept(1,2);
        map.forEach(biConsumer);
    }
}
