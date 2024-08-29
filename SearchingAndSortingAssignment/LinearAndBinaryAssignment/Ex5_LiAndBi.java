// Q5: Given a positive integer num, return true if num is a perfect square or false otherwise. A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
// Example 1:
// Input: num = 16
// Output: true
package SearchingAndSorting.LinearAndBinaryAssignment;

import java.util.Scanner;

public class Ex5_LiAndBi {
    public static boolean isPerfectSquare(int num) {

        // Edge case
        if (num == 1) {
            return true;
        }

        long start = 0; // Take Long as the inputs have large value
        long end = num / 2;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid > num)
                end = mid - 1; // Mid is greater than the squareroot of the number
            else if (mid * mid < num)
                start = mid + 1; // Mid is less than our required number
            else
                return true; // we found our squareroot number
        }
        return false;
    }

    public static void main(String args[]) {
        int m;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number : ");
            m = sc.nextInt();
        }
        System.out.println("The given number is a perfect square: " + isPerfectSquare(m));
    }
}
