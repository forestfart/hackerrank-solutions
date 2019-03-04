package oracle.oca;

import java.time.LocalDate;

public class AlgorToCheck {
    public static void main(String args[]) {
        int arr[][]={{1,3,5},{7,8}};
        out:for(int[] a :arr) {
            for (int i: a) {
                if (i == 7) continue;
                System.out.println(i + "");
                if (i == 3) break;
            }
            LocalDate date = LocalDate.of(2019,01,01).plusDays(56);
            date.plusDays(5);

            System.out.println(date);
        }


    }
}
