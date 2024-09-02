// Time Complexity: O(log₁₀(n))
// Space Complexity: O(log₁₀(n))

// Q1 : Given an integer, find out the sum of its digits using recursion.
// Input: n= 1234
// Output: 10
// Explanation: 1+2+3+4=10


/*
 Step 1: 1234 % 10 which is equal-to 4 + ( send 1234/10 to next step )
 Step 2: 123 % 10 which is equal-to 3 + ( send 123/10 to next step )
 Step 3: 12 % 10 which is equal-to 2 + ( send 12/10 to next step ) 
 Step 4-> 1 % 10 which is equal-to 1 + ( send 1/10 to next step ) 
 Step 5-> 0 algorithm stops.
*/

package Recursion.Assignment;
import java.util.Scanner;

public class Ex1_Rec {

    public static int func(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n % 10 + func(n / 10));
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the number:");
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int ans = func(n);
            System.out.println(" Sum of digits in " + n + " is " + ans);
        }
    }
}
