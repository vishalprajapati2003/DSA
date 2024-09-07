//  Q1. Given an integer array arr and an integer k, return true if it is possible to divide the vector into k non-empty subsets with equal sum.

// Input: arr = [1,3,2,2] k = 2
// Output: true
// Explanation : 1 + 3 and 2+2 are two subsets with equal sum.

package BackTracking.Assignment;

import java.util.Arrays;

// public class Ex1_BackTraking {

//     // Helper function to check if we can partition the array into k subsets with
//     // equal sum
//     public static boolean helper(int[] arr, int[] vis, int si, int curr_sum, int target, int k) {
//         // If only one subset is left, it must sum up correctly.
//         if (k == 1)
//             return true;
//         // If the current sum exceeds the target, stop.
//         if (curr_sum > target)
//             return false;
//         // Move to the next subset.
//         if (curr_sum == target)
//             return helper(arr, vis, 0, 0, target, k - 1);

//         for (int i = si; i < arr.length; i++) {
//             // If the element has not been visited
//             if (vis[i] == -1) { 
//                 vis[i] = 1; // Mark it as visited
//                 if (helper(arr, vis, i + 1, curr_sum + arr[i], target, k)){
//                     return true;
//                 }

//                 vis[i] = -1; // Backtrack

//                 // Skip consecutive duplicate elements to avoid redundant calls
//                 while (i + 1 < arr.length && arr[i] == arr[i + 1])
//                     i++;
//             }
//         }
//         return false;
//     }

//     // Main function to check if we can partition the array into k subsets with
//     // equal sum
//     public static boolean canPartition(int[] arr, int k) {
//         int n = arr.length;
//         int[] vis = new int[n];
//         // Initialize all elements as unvisited
//         Arrays.fill(vis, -1); 
//         int sum = 0;

//         // Calculate the total sum of the array
//         for (int num : arr)
//             sum += num;

//         // If the total sum is not divisible by k, return false
//         if (sum % k != 0)
//             return false;

//            // Each subset must sum to this value
//            int target = sum / k; 

//         // Sort the array in descending order to prioritize larger elements
//         Arrays.sort(arr);
//         for (int i = 0; i < n / 2; i++) {
//             int temp = arr[i];
//             arr[i] = arr[n - 1 - i];
//             arr[n - 1 - i] = temp;
//         }

//         // Early exit if the largest element is greater than the target sum
//         if (arr[0] > target)
//             return false;

//         // Start the backtracking process to check if we can partition
//         return helper(arr, vis, 0, 0, target, k);
//     }

//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 2, 3 };
//         int k = 2;

//         if (canPartition(arr, k)) {
//             System.out.println("Yes, it is possible to partition the array.");
//         } else {
//             System.out.println("No, it is not possible to partition.");
//         }
//     }
// }

public class Ex1_BackTraking {
    public static boolean helper(int[] nums, int start, int currentSum, int targetSum, int remainingSubsets,
            boolean[] visited) {
        if (remainingSubsets == 0) {
            return true;
        }

        if (currentSum == targetSum) {
            return helper(nums, 0, 0, targetSum, remainingSubsets - 1, visited);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= targetSum) {
                visited[i] = true;
                if (helper(nums, i + 1, currentSum + nums[i], targetSum, remainingSubsets, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int targetSum = Arrays.stream(nums).sum() / k;

        if (targetSum * k != Arrays.stream(nums).sum() || k > n) {
            return false;
        }

        boolean[] visited = new boolean[n];

        return helper(nums, 0, 0, targetSum, k, visited);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 3, 5, 2, 1 };
        int k = 4;

        if (canPartitionKSubsets(nums, k)) {
            System.out.println("Yes, it is possible to partition the array.");
        } else {
            System.out.println("No, it is not possible to partition.");
        }
    }
}