// given a number ‘n’, predict whether it is a power of two or not.

// Input 1: n = 15
// Output 1: False
// Input 2: n = 32
// Output 2: True

package SearchingAndSorting.NumberSystemAssignment;

import java.util.Scanner;

public class Ex2_Number {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number: ");
            int n = sc.nextInt();
            boolean result = isPowerOfTwo(n);
            if (result == true) {
                System.out.println(n + " is a power of two");
            } else {
                System.out.println(n + " is not a power of two");

            }
        }

    }
}

/*
Bitwise AND (&) operation:
The expression n & (n - 1) removes the lowest set bit from n. If n is a power of two, it will have only one set bit, so n & (n - 1) will be 0.

Check for positive number: 
The method checks if n is greater than 0 to handle cases where n is non-positive, as negative numbers and zero are not powers of two.

Example: 
For n = 16 (which is 2^4), the binary representation is 10000. 
n - 1 is 15, which has the binary representation 01111.
The bitwise AND of 10000 and 01111 is 00000, so the function will return true.
 */