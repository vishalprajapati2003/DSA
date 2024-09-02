// Q3: Print the max value of the array [ 13, 1, -3, 22, 5].
package Recursion.Assignment;

public class Ex3_Rec {
    public static int findMax(int[] arr, int n) {
        // Base case: if there's only one element
        if (n == 1) {
            return arr[0];
        }

        // Recursive case: find the maximum of the rest of the array
        int maxRest = findMax(arr, n - 1);

        // Compare the last element with the maximum of the rest
        return Math.max(arr[n - 1], maxRest);
    }

    public static void main(String[] args) {
        int[] arr = { 13, 1, -3, 22, 5 };
        int max = findMax(arr, arr.length);
        System.out.println("The maximum value in the array is: " + max);
    }
}
