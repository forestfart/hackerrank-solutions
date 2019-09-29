package oracle.ocp.functions;

import java.util.function.DoubleSupplier;

class ProductCode<T, U extends T> {
    private T number;
    private U code;

    ProductCode(T number, U code) {
        this.number = number;
        this.code = code;
    }

    public T getNumber() {
        return number;
    }

    public U getCode() {
        return code;
    }
}

public class PrimitiveFunctionNullPointer {
    public static void main(String[] args) {
        ProductCode<Number, Integer> product2 = new ProductCode<Number, Integer>(3, null);
        DoubleSupplier supplier = product2::getCode;
        System.out.println(supplier.getAsDouble());
    }
}
