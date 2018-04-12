package practice.algorithms.strings.determiningdnahealth;

import java.io.*;
import java.util.*;

class TrieNode {
    private final char character;
    private List<TrieNode> children = new ArrayList<>();
    private boolean isGen;
    private int healthValue;
    private TrieNode failNode;

    public TrieNode(final char character, boolean isGen, int healthValue) {
        this.character = character;
        this.isGen = isGen;
        this.healthValue = healthValue;
    }

    public TrieNode(final char character) {
        this.character = character;
        this.isGen = false;
    }

    public void addChild(TrieNode trieNode) {
        children.add(trieNode);
    }

    public void addHealthValue(int healthValue) {
        this.healthValue += healthValue;
    }

    public void setFailNode(TrieNode failNode) {
        this.failNode = failNode;
    }

    public boolean isGen() {
        return isGen;
    }

    public Optional<TrieNode> getChild(char character) {
        return children.stream().filter(child -> child.getCharacter() == character).findFirst();
    }

    public char getCharacter() {
        return character;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public List<TrieNode> getChildren() {
        return children;
    }

    public TrieNode getFailNode() {
        return failNode;
    }

    public void printTrie(TrieNode trie) {
        for (TrieNode element : trie.getChildren()) {
            System.out.printf("%c %b %d\n", element.getCharacter(), element.isGen(), element.getHealthValue());
            if (element.getChildren().size() != 0) printTrie(element);
        }
    }
}

public class Solution {

    private static void createFailNodes(final TrieNode trie) {
        // to do
    }

    private static void listGensFromTrie(TrieNode trieRoot, TrieNode trie, StringBuilder prefix) {
        for (TrieNode element : trie.getChildren()) {
            if (trie == trieRoot) prefix = new StringBuilder();
            prefix.append(element.getCharacter());
            if (element.isGen()) System.out.printf("%s \n", prefix);
            if (element.getChildren().size() != 0) listGensFromTrie(trieRoot, element, prefix);
        }
    }

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
            TrieNode trie = new TrieNode(' ');
            TrieNode trieRoot = trie;
            boolean isWord;
            TrieNode child;

            // create Trie node
            while(genesLine.hasMoreTokens()) {
                gen = genesLine.nextToken();
                health = Integer.parseInt(healthLine.nextToken());
                for (int index = 0; index < gen.length(); index++) {
                    child = trie.getChild(gen.charAt(index)).orElse(null);
                    if (child == null) {
                        if (index == gen.length()-1) {
                            child = new TrieNode(gen.charAt(index), true, health);
                        } else {
                            child = new TrieNode(gen.charAt(index));
                        }
                        trie.addChild(child);
                    } else if (index == gen.length()-1) {
                        child.addHealthValue(health);
                    }
                    trie = child;
                }
                trie = trieRoot;
            }
            trie.printTrie(trieRoot);
            listGensFromTrie(trieRoot, trieRoot, null);
            createFailNodes(trieRoot);

            // ongoing - calculate health
            List<Integer> dnaHealthList = new ArrayList<>();
            for (int a0 = 0; a0 < s; a0++) {
                health = 0;
                StringTokenizer dnaLine = new StringTokenizer(in.readLine());
                first = Integer.parseInt(dnaLine.nextToken());
                last = Integer.parseInt(dnaLine.nextToken());
                dna = dnaLine.nextToken();

                for (int i = 0; i < dna.length(); i++) {
                    child = trie.getChild(dna.charAt(i)).orElse(null);
                    if (child != null) {
                        if (child.isGen()) {
                            health += child.getHealthValue();
                        } else {
                            trie = child;
                        }
                    } else {} //to do
                }
            }
            in.close();
            //System.out.printf("%d %d", Collections.min(dnaHealthList), Collections.max(dnaHealthList));
        } catch (Exception e) {
            System.out.println(e);
        }
        long endMillis = System.currentTimeMillis();
        System.out.printf("\nElapsed time: %d ms", endMillis - startMillis);
    }
}