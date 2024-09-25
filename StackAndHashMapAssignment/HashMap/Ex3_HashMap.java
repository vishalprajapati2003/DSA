// Q3.Detect if an Array contains a duplicate element. At Most 1 duplicate would be there.
// Input: 1,2,3,4
// Output: No
// Input: 1, 2, 3, 4, 1
// Output: Yes.

// Time Complexity: O(n)
// Space Complexity: O(n)
package HashMap.Assignment;

import java.util.HashMap;
import java.util.Scanner;

public class Ex3_HashMap {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of elements of array: ");

            int n = sc.nextInt();
            int[] arr = new int[n];

            System.out.print("Enter the elements of array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            boolean duplicate = false;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(arr[i])) {
                    duplicate = true;
                    System.out.println("Yes");
                    break;
                }
                map.put(arr[i], 1);
            }
            if (duplicate == false)
                System.out.println("No");
        }
    }
}
