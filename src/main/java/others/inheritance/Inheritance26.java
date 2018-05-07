package others.inheritance;

class Mn {
    int i;
    public Mn(int i)
    {
        this.i = i--;
    }
}

class Nn extends Mn {
    public Nn(int i)
    {
        super(++i);
        System.out.println(i);
    }
}

public class Inheritance26 {
    public static void main (String[] args) {
        Nn n = new Nn(26);
    }
}
