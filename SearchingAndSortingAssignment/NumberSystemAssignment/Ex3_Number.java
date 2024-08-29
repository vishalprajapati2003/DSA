// Given a number. Using bit manipulation, check whether it is odd or even.
// Input: 8, Even
// Input: 3, False
package SearchingAndSorting.NumberSystemAssignment;

import java.util.Scanner;

public class Ex3_Number {
    public static void main(String[] args) {
        int number;
        System.out.println("Enter the integer: ");

        try (Scanner s = new Scanner(System.in)) {
            number = s.nextInt();
        }

        if ((number & 1) == 1)
            System.out.println("Given number is odd.");
        else
            System.out.println("Given number is even.");
    }
}
/*
Approach:

--> If the LSB is 1, the number is odd; if it's 0, the number is even.

Explanation:

Bitwise AND (&) operation with 1:

-->  The binary representation of 1 is 0001. 
-->  When you perform n & 1, it checks the last bit of the number n.
-->  If n & 1 is 0, the number is even.
-->  If n & 1 is 1, the number is odd.

Example:
For n = 8, the binary representation is 1000.
The LSB is 0, so 8 & 1 results in 0, meaning the number is even.

*/