package practice.algorithms.sorting.thefullcountingsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) /*throws FileNotFoundException*/ {

        //File resource = new File("src/main/resources/TheFullCountingSort.txt");
        //try { Scanner in = new Scanner(resource);

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, StringBuilder> map = new HashMap<>();
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            StringBuilder s = new StringBuilder(in.next());
            if (a0<(n/2)) { s.delete(0,s.length()).append("-"); }
            if (map.get(x)!=null) { map.put(x, map.get(x).append(" ").append(s)); }
            else { map.put(x, s); }
        }
        in.close();
        map.entrySet().stream().map(k->k.getValue().append(" ")).forEach(System.out::print);

        //} catch (Exception e) { System.out.println(e); }
    }
}
