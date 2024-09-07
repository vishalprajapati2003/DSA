// Q3. Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
// Input: nums = [1,1,2]
// Output: [[1,1,2],[1,2,1],[2,1,1]]
package BackTracking.Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex3_BackTracking {

    // Recursive method to find unique permutations
    private static void permute(List<List<Integer>> result, boolean[] visited, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            permute(result, visited, temp, nums);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    // Method to initialize and start the permutation process
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(result, visited, new ArrayList<>(), nums);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,0,3 };
        List<List<Integer>> permutations = permuteUnique(arr);
        System.out.println("Permutations for array " + Arrays.toString(arr) + " are: ");
        for (List<Integer> perm : permutations) {
            System.out.println(perm);
        }
    }
}