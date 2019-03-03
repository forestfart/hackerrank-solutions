package practice.algorithms.implementation.formingamagicsquare;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTests {


    @Test
    public void testInput00() {

        // Given
        System.out.println("--- test input 00 ---");
        Solution solution = new Solution();
        int[][] input = new int[3][3];
        input[0][0] = 4;
        input[0][1] = 9;
        input[0][2] = 2;
        input[1][0] = 3;
        input[1][1] = 5;
        input[1][2] = 7;
        input[2][0] = 8;
        input[2][1] = 1;
        input[2][2] = 5;

        // When
        int result = solution.formingMagicSquare(input);

        // Then
        //Assert.assertEquals(1, result);
    }

    @Test
    public void testInput22() {

        // Given
        System.out.println("--- test input 22 ---");
        Solution solution = new Solution();
        int[][] input = new int[3][3];
        input[0][0] = 4;
        input[0][1] = 8;
        input[0][2] = 2;
        input[1][0] = 4;
        input[1][1] = 5;
        input[1][2] = 7;
        input[2][0] = 6;
        input[2][1] = 1;
        input[2][2] = 6;

        // When
        int result = solution.formingMagicSquare(input);

        // Then
        //Assert.assertEquals(4, result);
    }

    @Test
    public void testInputMagicSquare() {

        // Given
        System.out.println("--- test input MagicSquare ---");
        Solution solution = new Solution();
        int[][] input = new int[3][3];
        input[0][0] = 8;
        input[0][1] = 3;
        input[0][2] = 4;
        input[1][0] = 1;
        input[1][1] = 5;
        input[1][2] = 9;
        input[2][0] = 6;
        input[2][1] = 7;
        input[2][2] = 2;

        // When
        int result = solution.formingMagicSquare(input);

        // Then
        //Assert.assertEquals(4, result);
    }
}
