package oracle.oca;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

interface Walk {
    default int getSpeed() {
        return 5;
    }
}

interface Run {
    default int getSpeed() {
        return 10;
    }
}

class Animal implements Run, Walk {

    public int getSpeed() {
        return 6;
    }

    public static void main(String[] args) {
        List ass = new ArrayList<>(1);
        ass.add(5);
        ass.add(1,1);

        Year y = Year.of(2015);
        LocalDate date = y.atMonthDay(MonthDay.of(4,30));
        System.out.println(date);
        System.out.println(" ".join("2", "@","@"));

        Animal animal = new Animal();
        System.out.println(animal.getSpeed()); // <-6!

        StringBuilder sb = new StringBuilder("sdfg");
        char[] ch = new char[3];
        sb.getChars(0,2, ch, 0);
        System.out.println("ch = " + ch[0] + ch[1] + ch[2]);
    }
}
