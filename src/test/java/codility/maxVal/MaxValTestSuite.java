package codility.maxVal;

import org.junit.Assert;
import org.junit.Test;

public class MaxValTestSuite {

    @Test
    public void testMaxValSolution() {
        // Given
        Solution solution = new Solution();
        int[] array = new int[900];
        // When
        for (int i=0; i < 900; i++) {
            array[i]=i;
        }
        // Then
        Assert.assertEquals(0, solution.solution(900, array));
    }

    @Test
    public void testMaxValSolutionFor3() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[] { 1, 3, 0 };
        // Then
        Assert.assertEquals(1, solution.solution(3, array));
    }

    @Test
    public void testMaxValSolutionFor30() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[] { 1, 0, 0 };
        // Then
        Assert.assertEquals(0, solution.solution(3, array));
    }

    @Test
    public void testMaxValSolutionFor31() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[] { 0, 1, 1 };
        // Then
        Assert.assertEquals(1, solution.solution(3, array));
    }

    @Test
    public void testMaxValSolutionFor1() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[] { 1 };
        // Then
        Assert.assertEquals(1, solution.solution(1, array));
    }

    @Test
    public void testMaxValSolutionFor0() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[] { 1 };
        // Then
        Assert.assertEquals(1, solution.solution(1, array));
    }

    @Test
    public void testMaxValSolutionFor3x3() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[] { 3, 3, 3 };
        // Then
        Assert.assertEquals(3, solution.solution(3, array));
    }
}
