package others;

import java.io.*;
import java.util.*;

public class ValidateBracketsNesting {
    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the ValidateBracketsNesting function below.
     */
    static boolean ValidateString(String input) {
        /*
         * Write your code here.
         */
        int angleBracketCounter = 0, lastAngleBracketCounterDepth = 0;
        int curlyBracketCounter = 0, lastCurlyBracketCounterDepth = 0;
        for (int i=0; i < input.length(); i++) {
            if (curlyBracketCounter != 0 && lastCurlyBracketCounterDepth != curlyBracketCounter) return false;
            if (angleBracketCounter != 0 && lastAngleBracketCounterDepth != angleBracketCounter) return false;
            if (curlyBracketCounter < 0 || angleBracketCounter < 0) return false;
            switch (input.charAt(i)) {
                case '<':
                    angleBracketCounter++;
                    lastAngleBracketCounterDepth = angleBracketCounter;
                    break;
                case '>':
                    angleBracketCounter--;
                    lastAngleBracketCounterDepth = angleBracketCounter;
                    break;
                case '{':
                    curlyBracketCounter++;
                    lastCurlyBracketCounterDepth = curlyBracketCounter;
                    break;
                case '}':
                    curlyBracketCounter--;
                    lastCurlyBracketCounterDepth = curlyBracketCounter;
                    break;
            }
        }
        if (angleBracketCounter == 0 && curlyBracketCounter == 0) {
            return true;
        } else { return false;}
    }

    public static void main(String[] args) throws IOException {
        boolean res;
        res = ValidateString("<<>>{}");
        System.out.println(res);
        res = ValidateString("<<{}>}>");
        System.out.println(res);
        res = ValidateString("<{<>}>");
        System.out.println(res);
        res = ValidateString("<<>{}>");
        System.out.println(res);
    }
}