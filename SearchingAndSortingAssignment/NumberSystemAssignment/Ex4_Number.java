// Q4. Given a number, count the number of set bits in that number without using an extra space.
// Note : bit ‘1’ is also known as set bit.
package SearchingAndSorting.NumberSystemAssignment;

import java.util.Scanner;

/*
Approach:
--> We have extracted the last digit (from right), of the number using the AND operator. By operating AND operator on 1 and the number the corresponding bits of 1 and the number will be ANDed.

--> Whatever will be the result of AND we will add it to our “count” variable because the result can only be 0 and 1.

--> So if there is a set bit it will automatically get summed up in the variable “count”0

--> Once we are done with the last digit, we need to check upon other digits as well.
*/

// public class Ex4_Number {

//     public static int countSetBits(int n) {
//         int count = 0;
//         while (n > 0) {
//             count += n & 1;
//             n >>= 1;
//         }
//         return count;
//     }

//     public static void main(String[] args) {
//         int number;
//         System.out.println("Enter the integer: ");

//         // Create Scanner object
//         Scanner s = new Scanner(System.in);

//         // Read the next integer from the screen
//         number = s.nextInt();

//         int answer = countSetBits(number);
//         System.out.println("The number of set bits in the given number are= " + answer);
//     }
// }



// Approach2:  simple and efficient method known as Brian Kernighan’s Algorithm, which repeatedly clears the lowest set bit until the number becomes zero.

public class Ex4_Number {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1); // Clear the lowest set bit
            count++;
        }
        return count;
    }

  
    public static void main(String[] args) {
        int number;
        System.out.println("Enter the integer: ");
            
        try (Scanner s = new Scanner(System.in)) {
            number = s.nextInt();
        }
        int answer = countSetBits(number);
        System.out.println("The number of set bits in the given number are= " + answer);
    }
}

/*
Explanation:

Bitwise AND with n-1: 
--> The operation n & (n - 1) clears the lowest set bit in n. 
--> Each time this operation is performed, the number of set bits decreases by one.

Count Increment: 
--> The loop continues until n becomes 0. 
--> The variable count is incremented with each iteration, representing the number of set bits.

Example:

For n = 29 (which is 11101 in binary):

--> First iteration: 29 & 28 → 11101 & 11100 → 11100 (one set bit cleared).
--> Second iteration: 28 & 27 → 11100 & 11011 → 11000 (another set bit cleared).
--> Third iteration: 24 & 23 → 11000 & 10111 → 10000 (another set bit cleared).
--> Fourth iteration: 16 & 15 → 10000 & 01111 → 00000 (final set bit cleared).
--> The loop runs 4 times, so the number of set bits is 4.
--> This method is efficient, with a time complexity of O(log n) where n is the given number, and it does not require any extra space.
 */