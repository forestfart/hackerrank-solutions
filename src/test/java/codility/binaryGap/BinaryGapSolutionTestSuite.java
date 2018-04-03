package codility.binaryGap;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGapSolutionTestSuite {

    @Test
    public void testSolutionFor1041 () {
        Solution solution = new Solution();
        Assert.assertEquals(5, solution.solution(1041));
    }

    @Test
    public void testSolutionFor15 () {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.solution(15));
    }

    @Test
    public void testSolutionFor16 () {
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.solution(16));
    }

    @Test
    public void testSolutionFor0 () {
        Solution solution = new Solution();
        Assert.assertEquals(1, solution.solution(0));
    }

    @Test
    public void testSolutionFor1 () {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.solution(1));
    }



    @Test
    public void testSolutionForUpperBand () {
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.solution((int)Math.pow(2,31)));
    }

    @Test
    public void testSolutionFor1052929 () {
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.solution(1052929));
    }

    @Test
    public void testSolutionFor1073341824 () {
        Solution solution = new Solution();
        Assert.assertEquals(7, solution.solution(1073341824));
    }

    @Test
    public void testSolutionForUpperBandMinus1 () {
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.solution(((int)Math.pow(2,31))-7));
    }
}
