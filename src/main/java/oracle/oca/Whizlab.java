package oracle.oca;

import static java.lang.System.out;

public class Whizlab {

    public final static void main(String[] args) {
        out.println(Speed.FASTER == Speed.FAST);
        out.println(Speed.SLOW == Speed.SLOW);
        out.println(Speed.SLOW == Speed.SAME);
    }
}

enum Speed {
    FAST(2),
    FASTER(3),
    SLOW(1),
    SAME(1);

    private final int speed;

    Speed(int speed) {
        this.speed = speed;
    }
}
