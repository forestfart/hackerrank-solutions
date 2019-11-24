package codility.longestDistinctBinaryTree;

import java.util.*;

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}

public class Solution {
    private static int max = 0;

    public static void main(String[] tree) {
        Solution solution = new Solution();
        solution.solution(new Tree());
    }

    public int solution(Tree tree) {
        // write your code in Java SE 8
        return traverse(tree, new HashSet<>());
    }

    private static int traverse(Tree node, Set<Integer> trace) {
        if (trace.add(node.x)) {
            if (max < trace.size()) max = trace.size();
            if (node.l != null) {
                traverse(node.l, new HashSet<>(trace));
            }
            if (node.r != null) {
                traverse(node.r, new HashSet<>(trace));
            }
        }
        return max;
    }
}
