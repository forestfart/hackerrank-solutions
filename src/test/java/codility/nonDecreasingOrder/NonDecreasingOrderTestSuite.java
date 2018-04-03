package codility.nonDecreasingOrder;

import org.junit.Assert;
import org.junit.Test;

public class NonDecreasingOrderTestSuite {

    @Test
    public void testNonDecreasingOrder1() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[]{1, 5, 3, 3, 7};
        // Then
        Assert.assertTrue(solution.solution(array));
    }

    @Test
    public void testNonDecreasingOrder2() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[]{ 1, 3, 5, 3, 4 };
        // Then
        Assert.assertFalse(solution.solution(array));
    }

    @Test
    public void testNonDecreasingOrder3() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[]{1, 1, 1, 1, 1, 1};
        // Then
        Assert.assertTrue(solution.solution(array));
    }

    @Test
    public void testNonDecreasingOrder4() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[]{ 0, 1, 0, 1, 0, 0};
        // Then
        Assert.assertFalse(solution.solution(array));
    }

    @Test
    public void testNonDecreasingOrder5() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[]{ 0, 1, 0, 1, 0, 9};
        // Then
        Assert.assertTrue(solution.solution(array));
    }

    @Test
    public void testNonDecreasingOrder6() {
        // Given
        Solution solution = new Solution();
        // When
        int[] array = new int[]{ 1 };
        // Then
        Assert.assertTrue(solution.solution(array));
    }
}
