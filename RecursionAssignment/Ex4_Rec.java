//Q4 : Find the sum of the values of the array [92, 23, 15, -20, 10].

package Recursion.Assignment;

public class Ex4_Rec {
    public static int findSum(int[] arr, int n) {
        // Base case: if the array has only one element
        if (n == 0) {
            return 0;
        }

        // Recursive case: sum the last element and the sum of the remaining elements
        return arr[n - 1] + findSum(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 92, 23, 15, -20, 10 };
        int sum = findSum(arr, arr.length);
        System.out.println("The sum of the values in the array is: " + sum);
    }
}
