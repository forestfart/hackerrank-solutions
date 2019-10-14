package oracle.ocp.clazz;

import java.util.stream.Stream;

public class EqualsOrNot {
    String name;

    public EqualsOrNot(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        EqualsOrNot equalsOrNot1 = new EqualsOrNot("abc");
        EqualsOrNot equalsOrNot2 = equalsOrNot1;
        System.out.println(equalsOrNot1.equals(equalsOrNot2));
        EqualsOrNot equalsOrNot3 = new EqualsOrNot("abc");
        System.out.println(equalsOrNot1.equals(equalsOrNot3));

    }
}

class Bookie {
    int id;
    String name;
    public Bookie (int id, String name)  {
        this.id = id;
        this.name = name;
    }
    public boolean equals(Object obj) {           //line n1
        boolean output = false;
        Bookie b = (Bookie) obj;
        if (this.name.equals(b.name)){
            output = true;
        }
        return output;
    }

    public static void main(String[] args) {
        Bookie b1 = new Bookie(101, "Java Programing");
        Bookie b2 = new Bookie(102, "Java Programing");
        System.out.println(b1.equals(b2));                 //line n2

    }
}

