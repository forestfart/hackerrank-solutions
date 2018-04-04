package practice.algorithms.strings.determiningdnahealth;

import java.io.*;
import java.util.*;

public class Solution {

    public static int findLongestGenLength (int first, int last, String[] genes) {
        int longestGen = 0;
        for (int i = first; i < last; i++) {
            if (genes[i].length() > longestGen) longestGen = genes[i].length();
        }
        return longestGen;
    }

    public static int getHealthSum(int first, int last, StringBuilder d, String[] genes, int[] health) {
        int healthSum = 0;
        int longestGen = findLongestGenLength(first, last, genes);
        boolean isFlagUp;
        for (int dIndex = 0; dIndex < d.length(); dIndex++) {
            for (int genes_i = first; genes_i <= last; genes_i++) {
                isFlagUp = false;
                for (int genLength = longestGen; genLength > 0; genLength--) {
                    if (dIndex <= (d.length() - genLength)) {
                        if (d.substring(dIndex, dIndex + genLength).equals(genes[genes_i]) && !isFlagUp) {
                            healthSum = healthSum + health[genes_i];
                            isFlagUp = true;
                        }
                    }
                }
            }
        }
        return healthSum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int n;
        String[] genes;
        int[] health;
        File resource = new File("src/main/resources/DeterminingDnaHealth.txt");
        try {
            Scanner in = new Scanner(resource);
            n = in.nextInt();
            genes = new String[n];
            for (int genes_i = 0; genes_i < n; genes_i++) {
                genes[genes_i] = in.next();
            }
            health = new int[n];
            for (int health_i = 0; health_i < n; health_i++) {
                health[health_i] = in.nextInt();
            }
            int s = in.nextInt();
            List<Integer> dnaList = new ArrayList<>();
            for (int a0 = 0; a0 < s; a0++) {
                int first = in.nextInt();
                int last = in.nextInt();
                StringBuilder d = new StringBuilder(in.next());
                dnaList.add(getHealthSum(first, last, d, genes, health));
            }
            in.close();
            System.out.printf("%d %d", Collections.min(dnaList), Collections.max(dnaList));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
