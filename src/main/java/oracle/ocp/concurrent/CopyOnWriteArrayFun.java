package oracle.ocp.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayFun {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("we");
        list.add("all");
        list.remove("we");
        list.removeIf(n -> n.contains("al"));
        list.addAll(Arrays.asList("now", "they", "know"));
        list.addAll(0, Arrays.asList("God", "trust", "future"));
        System.out.println(list);
    }
}
