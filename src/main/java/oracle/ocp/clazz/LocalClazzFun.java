package oracle.ocp.clazz;

public class LocalClazzFun {
    static int statInt = 40;
    int in = 20;

    void callOtherMethod(int in1, int in2) {

        class MethodInnerClazz {
            public int returnIt(int zzz) {
                zzz = statInt + zzz + in + in1 + in2;
                return zzz;
            }
        }
        // in1++; not allowed here.. variables referenced from an inner class must be final or effectively final

        System.err.println(new MethodInnerClazz().returnIt(76));
        System.err.write(5);
    }

    public static void main(String[] args) {
        int x = 10;
        new LocalClazzFun().callOtherMethod(23,30);
    }
}
