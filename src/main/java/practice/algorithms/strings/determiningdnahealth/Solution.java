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
        FileReader resource = new FileReader("src/main/resources/DeterminingDnaHealth.txt"); // Large file expected output is "118731899 118731899", medium: "3218660 11137051"
        try {
            BufferedReader in = new BufferedReader(resource);
            int n = Integer.parseInt(in.readLine());
            String genesLine = in.readLine();
            StringBuffer genesLineBuff = new StringBuffer(genesLine);
            genesLineBuff.chars().spliterator().trySplit();
            String[] genes = genesLine.split(" ");
            String healthLine = in.readLine();
            int[] health = Arrays.stream(healthLine.split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = Integer.parseInt(in.readLine());
            List<Integer> dnaHealthList = new ArrayList<>();
            //System.out.println(n + " " + s);
            //System.out.println("genes :" + genesLine);
            //System.out.println("healthLine: " + healthLine);
            for (int a0 = 0; a0 < s; a0++) {
                String d = new String(in.readLine());
                String[] splitLine = d.split(" ");
                //System.out.printf("first %d, last %d; ", Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));
                dnaHealthList.add(getHealthSum(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), new StringBuilder(d), genes, health));
            }
            in.close();
            System.out.printf("%d %d", Collections.min(dnaHealthList), Collections.max(dnaHealthList));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}