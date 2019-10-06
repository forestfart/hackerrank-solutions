package oracle.ocp.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Product {
    int id; int price;
    public Product (int id, int price) {
        this.id = id; this.price = price;
    }
    public String toString() {
        return id + "-" + price;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(4);
        products.add(new Product(1,10));
        products.add(new Product(2, 30));
        products.add(new Product(2, 30));
        Product product = products.stream().reduce(new Product(4, 0), ((product1, product2) -> {
            product1.price += product2.price;
            System.out.println("Id: " + product1.id + " price: " + product1.price);
            return new Product(product1.id, product1.price);
        }));
        products.add(product);
        products.stream()
                .peek(e -> System.out.println("e: " + e))
                .parallel()
                .peek(e -> System.err.println(e))
                .reduce((p1, p2) -> p1.price > p2.price ? p1 : p2)
                .ifPresent(result -> System.out.println("Result: " + result));
    }
}

public class ReduceFun {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("what ", "whot ", "whoooot ", "whooooot! ");
        String concatenated = list.stream().reduce("Just saying: ", (str, ds) -> str.concat(ds));
        System.out.println(concatenated);
    }
}

class Images {
    public static void main(String[] args) {
        List<String> codes = Arrays.asList ("DOC", "MPEG", "JPEG");
        codes.forEach (c -> System.out.print(c + " "));
        String fmt = codes.stream()
                .filter (s-> s.contains ("PEG"))
                .reduce((s, t) -> s + t).get();
        System.out.println("\n" + fmt);

        Predicate<String> predicate = n -> n.contains("P");
        List<String> list = codes.stream().filter(n -> n.length()>3).filter(predicate).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("ParallelStream results: " + codes.parallelStream().isParallel());
        String answer = codes.stream().parallel().reduce("Prefix_", (str1, str2) -> str1.concat(str2 + " "));
        System.out.println(answer);
    }
}
