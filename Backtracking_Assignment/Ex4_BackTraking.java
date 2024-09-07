// Q4. Check if the product of some subset of an array is equal to the target value.
// Input: n = 5 , target = 16 , Array = [2 3 2 5 4]
// Here the target will be equal to 2x2x4 = 16
// Output: Yes
package BackTracking.Assignment;

import java.util.Scanner;

public class Ex4_BackTraking {
    public static boolean solve(int n, int target, int[] arr, int i, int product) {
        if (i == n) {
            return product == target;
        }
        boolean Include = solve(n, target, arr, i + 1, product * arr[i]);
        boolean Exclude = solve(n, target, arr, i + 1, product);
        return (Include || Exclude);
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of elements you want and the value of target respectively : ");

            int n = sc.nextInt();
            int target = sc.nextInt();
            int a[] = new int[n];
            System.out.println("Enter the array elements");
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println((solve(n, target, a, 0, 1) ? "YES" : "NO"));
        }
    }
}
