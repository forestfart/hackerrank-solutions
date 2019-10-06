package oracle.ocp.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
