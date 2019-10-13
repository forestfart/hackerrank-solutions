package oracle.ocp.clazz;

class ProductCode<T, U extends T> {
    private T number;
    private U code;

    ProductCode(T number, U code) {
        this.number = number;
        this.code = code;
    }
}

public class GenericsFun {
    public static void main(String[] args) {
        ProductCode<Number, Integer> product2 = new ProductCode<Number, Integer>(3, 122);
        ProductCode<Number, Double> product1 = new ProductCode<>(3.2,123.2);
    }
}

class Test<T> {
    private T t;
    public T get ()  {
        return t;
    }
    public void set (T t)    {
        this.t = t;
    }
    public static void main (String args[]) {
        Test<String> type = new Test<>();
        Test type1 = new Test(); 		//line n1
        type.set("Java");
        type1.set(100);   			    //line n2
        System.out.print(type.get() + " " + type1.get());
    }
}
