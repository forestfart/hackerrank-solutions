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

abstract class Bigable {
    public abstract void doThat(String s);
}

interface Doable {
    public void doSomething(String s);
}

class Task extends Bigable implements Doable  {
    public void doSometingElse(String s) {}

    public void doThat(String s){};

    public void doSomething(String s){};
}
/*abstract class Work implements Doable {
    public abstract void doSomething(String s){};
    public void doYourThing(Boolean b) {}
}
class Job implements Doable {
    public void doSomething(Integer i) {}
}
class Action implements Doable {
    public void doSomething(Integer i) {}
    public String doThis(Integer j) {}
}*/
class Do implements Doable {
    public void doSomething(Integer i) {}
    public void doSomething(String s) {}
    public void doThat(String s) {}
}

