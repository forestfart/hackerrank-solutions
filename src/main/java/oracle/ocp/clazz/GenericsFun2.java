package oracle.ocp.clazz;

class Foo<K, V> {
    private K key;
    private V value;

    public Foo(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <T> Foo<T, T> twice(T value) {
        return new Foo<T, T>(value, value);
    }
}

public class GenericsFun2 {
    public static void main(String[] args) {
        Foo<String, Integer> foo1 = new Foo<String, Integer>("Fooooo", 2);
        Foo<? extends Number, ? super String> foo2 = new Foo<>(5, "sadf.dhg");
        Foo<String, String> foo3 = new Foo<String, String>("Fooooo", "2");
        Foo<String, String> foo4 = Foo.<String>twice("23");
    }
}
