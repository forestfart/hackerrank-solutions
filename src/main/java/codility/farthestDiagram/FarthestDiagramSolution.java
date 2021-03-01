package codility.farthestDiagram;

public class FarthestDiagramSolution {

    public int solution(String S) {
        // write your code in Java SE 8
        int distance;
        int max = 0;
        for (int index = 0; index < S.length() - 1; index++) {
            for (int n = S.length() - 1; n > index + max; n--) {
                if (S.charAt(index) == S.charAt(n - 1) && S.charAt(index + 1) == S.charAt(n)) {
                    distance = (n - 1) - index;
                    if (distance > max) max = distance;
                    System.out.print(max);
                }
            }
        }
        return max;
    }

}
