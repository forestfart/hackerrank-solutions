package oracle.ocp.clazz;

public interface InterfaceFun {

    default String toStringNOOOOO() {
        int someCode = 56;
        return Integer.toString(someCode);
    }

    static boolean equalsNOOOO(Object o) {
        return true;
    };

}
