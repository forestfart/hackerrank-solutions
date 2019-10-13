package oracle.ocp.io;

public class TryWithResourcesFun implements AutoCloseable{
    int var;
    public void close() {}
    public TryWithResourcesFun copyObjectReference() {
        return this;
    }

    public static void main(String[] args) {
        TryWithResourcesFun tryWithResourcesFun = null;
        try (TryWithResourcesFun newFun = new TryWithResourcesFun()) {
            newFun.var = 100;
            tryWithResourcesFun = newFun.copyObjectReference();
        }
        System.out.println(tryWithResourcesFun.var);
    }
}

class TryWithResourcesFun2 implements AutoCloseable{
    public void close() throws Exception {
        throw new RuntimeException();
    }
    public TryWithResourcesFun2 copyObjectReference() {
        return this;
    }

    public static void main(String[] args) throws Exception{
        TryWithResourcesFun2 tryWithResourcesFun2 = null;
        try (TryWithResourcesFun2 newFun = new TryWithResourcesFun2()) {
            newFun.copyObjectReference();
        }
    }
}


