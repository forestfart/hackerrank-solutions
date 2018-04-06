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

    public static int getHealthSum(int first, int last, StringBuffer d, String[] genes, int[] health) {
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
        FileReader resource = new FileReader("src/main/resources/DeterminingDnaHealthMedium.txt"); // Large file expected output is "118731899 118731899", medium: "3218660 11137051"
        try {
            BufferedReader in = new BufferedReader(resource);
            StringTokenizer sTokenLine = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(sTokenLine.nextToken());
            StringTokenizer genesLine = new StringTokenizer(in.readLine());
            String[] genes = new String[n];
            int index = 0;
            while (genesLine.hasMoreTokens()) {
                genes[index] = genesLine.nextToken();
                index++;
            }
            StringTokenizer healthLine = new StringTokenizer(in.readLine());
            //int[] health = Arrays.stream(healthLine.split(" ")).mapToInt(Integer::parseInt).toArray();
            index = 0;
            int[] health = new int[n];
            while (healthLine.hasMoreTokens()) {
                health[index] = Integer.parseInt(healthLine.nextToken());
                index++;
            }

            StringTokenizer sLine = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(sLine.nextToken());
            List<Integer> dnaHealthList = new ArrayList<>();
            //System.out.println(n + " " + s);
            //System.out.println("genes :" + genesLine);
            //System.out.println("healthLine: " + healthLine);
            for (int a0 = 0; a0 < s; a0++) {
                StringTokenizer dLine = new StringTokenizer(in.readLine());
                List<StringBuffer> splitLine = new ArrayList<>();
                while (dLine.hasMoreTokens()) {
                    splitLine.add(new StringBuffer(dLine.nextToken()));
                }
                //System.out.printf("first %d, last %d; ", Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));
                dnaHealthList.add(getHealthSum(Integer.parseInt(splitLine.get(0).toString()), Integer.parseInt(splitLine.get(1).toString()), splitLine.get(2), genes, health));
            }
            in.close();
            System.out.printf("%d %d", Collections.min(dnaHealthList), Collections.max(dnaHealthList));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}