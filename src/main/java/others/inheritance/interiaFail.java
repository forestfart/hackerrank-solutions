package others.inheritance;

class Ai
{
    int i = 1212;
}

class Bi extends Ai
{
    Ai a;

    public Bi(Ai a)
    {
        this.a = a;
    }
}

public class interiaFail {
    public static void main(String[] args)
    {
        Ai a = new Ai();

        Bi b = new Bi(a);

        System.out.println(a.i);

        System.out.println(b.i);

        System.out.println(b.a.i);

        b.a.i = 2121;

        System.out.println("--------");

        System.out.println(a.i);

        System.out.println(b.i);
    }
}
