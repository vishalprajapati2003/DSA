// Q2. Given an integer array arr, print all the possible permutations of the given array.
// Note : The array will only contain non repeating elements.

// Input: arr = [1, 2, 3]
// Output:[[1,2,3] , [1,3,2] , [2,1,3] , [2,3,1] , [3,1,2] , [3,2,1]]
package BackTracking.Assignment;
import java.util.Arrays;
public class Ex2_BackTraking {
    
    // Swap elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void permute(int[] arr, int l, int r) {
        if (l == r) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, r);
                // Backtracking
                swap(arr, l, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int n1 = arr1.length;
        System.out.println("Permutations for array : " + Arrays.toString(arr1) + " are : ");
        permute(arr1, 0, n1 - 1);
        System.out.println();

        int[] arr2 = {1, 2, 3};
        int n2 = arr2.length;
        System.out.println("Permutations for array : " + Arrays.toString(arr2) + " are : ");
        permute(arr2, 0, n2 - 1);
    }
}



//  Leetcode Answer 
/*
 class Solution {

    // Swap elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void FindPermute(int[] arr, int l, int r, List<List<Integer>> result) {
        if (l == r) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : arr) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                FindPermute(arr, l + 1, r, result);
                // Backtracking
                swap(arr, l, i);
            }
        }
    }

      public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        FindPermute(nums, 0, nums.length - 1, result);
        return result;
    }
}

 */