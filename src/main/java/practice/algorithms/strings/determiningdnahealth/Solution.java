package practice.algorithms.strings.determiningdnahealth;

import java.io.*;
import java.util.*;

class HealthCalculator extends Thread {
    private static int first, last, healthSum;
    private static StringBuffer d;
    private static String[] genes;
    private static volatile int[] health;

    HealthCalculator(int first, int last, StringBuffer d, String[] genes, int[] health, ThreadGroup tg, String name) {
        super(tg,name);
        this.first = first;
        this.last = last;
        this.d = d;
        this.genes = genes;
        this.health = health;
    }

    public int findLongestGenLength(int first, int last, String[] genes) {
        int longestGen = 0;
        for (int i = first; i < last; i++) {
            if (genes[i].length() > longestGen) longestGen = genes[i].length();
        }
        return longestGen;
    }

    public void run() {
        healthSum = 0;
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
    }

    public int getHealthSum() {
        return healthSum;
    }

}

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        long startMillis = System.currentTimeMillis(); // On tokenizer without threads: small: 0026ms medium: 0150ms large: ???
        FileReader resource = new FileReader("src/main/resources/DeterminingDnaHealthMedium.txt"); // Large file expected output is "118731899 118731899", medium: "3218660 11137051"
        ThreadGroup tg = new ThreadGroup("main");
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
            index = 0;
            int[] health = new int[n];
            while (healthLine.hasMoreTokens()) {
                health[index] = Integer.parseInt(healthLine.nextToken());
                index++;
            }
            StringTokenizer sLine = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(sLine.nextToken());
            List<Integer> dnaHealthList = new ArrayList<>();
            for (int a0 = 0; a0 < s; a0++) {
                StringTokenizer dLine = new StringTokenizer(in.readLine());
                List<StringBuffer> splitLine = new ArrayList<>();
                while (dLine.hasMoreTokens()) {
                    splitLine.add(new StringBuffer(dLine.nextToken()));
                }
                HealthCalculator healthCalculator = new HealthCalculator(Integer.parseInt(splitLine.get(0).toString()), Integer.parseInt(splitLine.get(1).toString()), splitLine.get(2), genes, health, tg, "healthCalc"+a0);
                healthCalculator.start();

                while(tg.activeCount()>0)  // wait for threads to finish
                {
                    try { Thread.sleep(0); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                }
                dnaHealthList.add(healthCalculator.getHealthSum());
            }
            in.close();
            System.out.printf("%d %d", Collections.min(dnaHealthList), Collections.max(dnaHealthList));
        } catch (Exception e) {
            System.out.println(e);
        }
        long endMillis = System.currentTimeMillis();
        long milliseconds = (endMillis-startMillis);
        long minutes = milliseconds / 60000;
        long seconds = milliseconds / 1000 - (minutes * 60);
        milliseconds =  milliseconds % 1000;
        System.out.println(String.format("\nElapsed time: %d min %d sec %d ms", minutes, seconds, milliseconds));
    }
}