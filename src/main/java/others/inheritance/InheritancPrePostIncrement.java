package others.inheritance;

class X {
    int m = 1111;

    {
        m = m++;
        System.out.println(m);
    }
}

class Y extends X {
    {
        System.out.println(methodOfY() + " <-");
    }

    int methodOfY() {
        return m-- + --m;
    }
}

public class InheritancPrePostIncrement {
    public static void main(String[] args)
    {
        Y y = new Y();
    }
}
