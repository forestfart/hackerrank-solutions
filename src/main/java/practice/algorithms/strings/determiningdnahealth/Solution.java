package practice.algorithms.strings.determiningdnahealth;

import java.io.*;
import java.util.*;

class TrieNode {
    private char character;
    private int value;
    private boolean isWord;
    private List<TrieNode> children = new LinkedList<>();

    public TrieNode(char character, int value, boolean isWord, TrieNode children) {
        this.character = character;
        this.value = value;
        this.isWord = isWord;
        this.children.add(children);
    }

    public int getValue() {
        return value;
    }
}

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        long startMillis = System.currentTimeMillis(); // On tokenizer without threads: small: 0026ms medium: 0150ms large: ???

        FileReader resource = new FileReader("src/main/resources/DeterminingDnaHealth.txt"); // Large file expected output is "118731899 118731899", medium: "3218660 11137051"
        try {
            BufferedReader in = new BufferedReader(resource); // new InputStreamReader(System.in) <<- on the website

            StringTokenizer nTokenLine = new StringTokenizer(in.readLine());
            StringTokenizer genesLine = new StringTokenizer(in.readLine());
            StringTokenizer healthLine = new StringTokenizer(in.readLine());
            StringTokenizer sLine = new StringTokenizer(in.readLine());

            int n = Integer.parseInt(nTokenLine.nextToken());
            int s = Integer.parseInt(sLine.nextToken());

            String gen, dna;
            int health, first, last;
            TrieNode trieNode;
            boolean isWord;

            // create Trie node
            while(genesLine.hasMoreTokens()) {
                gen = genesLine.nextToken();
                health = Integer.parseInt(healthLine.nextToken());
                for (int index = 0; index < gen.length(); index++) {
                    if (index == gen.length()) isWord = true;
                    else isWord = false;
                    trieNode = new TrieNode(gen.charAt(index), health, isWord, null);
                    // to do
                }
            }

            List<Integer> dnaHealthList = new ArrayList<>();

            for (int a0 = 0; a0 < s; a0++) {
                StringTokenizer dnaLine = new StringTokenizer(in.readLine());
                first = Integer.parseInt(dnaLine.nextToken());
                last = Integer.parseInt(dnaLine.nextToken());
                dna = dnaLine.nextToken();
            }

            // to do


            in.close();
            System.out.printf("%d %d", Collections.min(dnaHealthList), Collections.max(dnaHealthList));
        } catch (Exception e) {
            System.out.println(e);
        }
        long endMillis = System.currentTimeMillis();
        System.out.printf("\nElapsed time: %d ms", endMillis - startMillis);
    }
}