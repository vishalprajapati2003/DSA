// Q5. Given a number n. Print if it is an armstrong number or not. An armstrong number is a number if the sum of every digit in that number raised to the power of total digits in that number is equal to the number.
// Example : 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 hence 153 is an armstrong number. 
// Input1 : 153
// Output1 : Yes
// Input 2 : 134
// Output2 : No
package Recursion.Assignment;

public class Ex5_Rec {
    public static int countDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return 1 + countDigits(n / 10);
    }

    // Function to calculate the sum of each digit raised to the power of the number of digits
    public static int ArmstrongSum(int n, int numDigits) {
        if (n == 0) {
            return 0;
        }
        int digit = n % 10;
        return (int) Math.pow(digit, numDigits) + ArmstrongSum(n / 10, numDigits);
    }

    public static void main(String[] args) {
        // int n = 8208; // You can change this number to test other cases
        int n= 153;
        int numDigits = countDigits(n);
        int armstrongSum = ArmstrongSum(n, numDigits);

        if (armstrongSum == n) {
            System.out.println(n + " is an Armstrong number.");
        } else {
            System.out.println(n + " is not an Armstrong number.");
        }
    }
}




// public class Ex5_Rec {

//     // Function to calculate the sum of each digit raised to the power of the number of digits
//     public static int armstrongSum(int n, int numDigits) {
//         if (n == 0) {
//             return 0;
//         }
//         int digit = n % 10;
//         return (int)Math.pow(digit, numDigits) + armstrongSum(n / 10, numDigits);
//     }

//     public static void main(String[] args) {
//         int n = 153;  // You can change this number to test other cases
//         int numDigits = String.valueOf(n).length();  // Count digits by converting number to string
//         int sum = armstrongSum(n, numDigits);
        
//         if (sum == n) {
//             System.out.println(n + " is an Armstrong number.");
//         } else {
//             System.out.println(n + " is not an Armstrong number.");
//         }
//     }
// }






