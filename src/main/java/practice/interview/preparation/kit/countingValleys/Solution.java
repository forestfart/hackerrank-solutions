package practice.interview.preparation.kit.countingValleys;

public class Solution {

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int counter = 0;
        int valleys = 0;
        boolean startValley = false;
        for (int index = 0; index < steps; index++) {
            if (path.charAt(index) == 85) {
                if (counter == -1) {
                    startValley = false;
                    valleys++;
                }
                counter++;
            } else if (path.charAt(index) == 68) {
                if (counter == 0) startValley = true;
                counter--;
            }
        }
        return valleys;
    }
}
