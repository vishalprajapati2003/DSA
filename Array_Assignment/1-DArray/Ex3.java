// Q3: Write a program to calculate the maximum element in the array.

// Input 1: arr[] = {34,21,54,65,43}
// Output 1: 65
// Input 1: arr[] = {4,3,6,7,1}
// Output 1: 7



// Approach:
// * We will traverse the array, and will keep a max variable that will be updated with the current element of the
// array if the array element is greater than the value of max variable.
// * Initially the max variable is given the minimum integer value.
package Assignment;

public class Ex3 {
    public static void main(String[] args) {
        int[] arr = { 10, 7, -5, 8, 9, 0, -4 };
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }
        System.out.print("Largest in given array is " + max);

    }
}
