package codility.maxAsceedingSlice;

import org.junit.Assert;
import org.junit.Test;

public class AsceedingArrayTestSuite {
    @Test
    public void testBasic() {
        Solution solution = new Solution();
        int[] input = new int[10];

        input[0] = 2;
        input[1] = 2;
        input[2] = 2;
        input[3] = 2;
        input[4] = 1;
        input[5] = 2;
        input[6] = -1;
        input[7] = 2;
        input[8] = 1;
        input[9] = 3;

        Assert.assertEquals(4, solution.solution(input));
    }

    @Test
    public void testBasic2() {
        Solution solution = new Solution();
        int[] input = new int[3];

        input[0] = 10;
        input[1] = 20;
        input[2] = 30;

        Assert.assertEquals(0, solution.solution(input));
    }
}
