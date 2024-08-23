// Q1: Write a program to print the sum of all the elements present on even indices in the given array.

// Input 1: arr[] = {3,20,4,6,9}
// Output 1: 16

// Input 1: arr[] = {4,3,6,7,1}
// Output 1: 11

package Assignment;

public class Ex1 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int sum = 0;

        // Loop through the array with a step of 2, starting from index 0
        for (int i = 0; i < arr.length; i += 2) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
