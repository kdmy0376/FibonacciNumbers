package dw.koo.android.fibonaccinumbers;

/**
 * F(n)
 * 0, if n == 0
 * 1, if n == 1
 * F(n-1) + F(n-2), if n > 1
 *
 * F(0) = 0
 * F(1) = 1
 * F(2) = 1, F(3) = 2, F(4) = 3
 * 0, 1, 1, 2, 3, 5, 8...
 */
public class Fibonacci {

    /* 2^n - 1 => O(2^n) */
    private int fiboRecursion(int number) {
        if (number == 0 || number == 1) {
            return number;
        }
        return fiboRecursion(number - 1) + fiboRecursion(number - 2);
    }

    /* O(n) */
    private long[] fiboMemoization = new long[100];

    private long fiboDynamicProgramming(int number) {
        if (number <= 1) {  /* 0 or 1 */
            return number;

        } else if (fiboMemoization[number] != 0) {
            return fiboMemoization[number];

        } else {
            return fiboMemoization[number] = fiboDynamicProgramming(number - 1) + fiboDynamicProgramming(number - 2);
        }
    }

    /* n -1 => O(n) */
    private int fiboIteration(int number) {
        if (number == 0 || number == 1) {
            return number;
        }
        int lowVal = 0;
        int highVal = 1;
        int result = 0;

        /* Original highVal --> lowVal, Current result --> highVal */
        for (int i = 1; i < number; i++) {
            result = lowVal + highVal;
            lowVal = highVal;
            highVal = result;
        }
        return result;
    }
}
