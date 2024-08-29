/* 
Given an array and an integer “target”, return the last occurrence of “target” in the array. If the target is not present return -1.

Input 1: arr = [1 1 1 2 3 4 4 5 6 6 6 6] , target = 4
Output 1: 6
Input 2: arr = [2 2 2 6 6 18 29 30 30 30] , target = 15
Output 2: -1 
*/
package SearchingAndSorting.LinearAndBinaryAssignment;

import java.util.Scanner;

public class Ex2_LiAndBi {

    public static int lastOccurrence(int[] nums, int low, int high, int target) {
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                answer = mid;
                low = mid + 1; // if you found the target or if target is greater than the current element, to
                               // find last occurrence move to right half of the array
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return answer;
    }

    public static void main(String args[]) {

        int m;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of elements you want to add : ");
            m = sc.nextInt();

            int[] arr = new int[m];

            System.out.print("Enter the elements of the array: ");

            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.print("Enter the target : ");

            int target;
            target = sc.nextInt();
            System.out.println("The last occurrence of target is at index : " + lastOccurrence(arr, 0, m - 1, target));
        }
    }
}


/*
Approach:

--> Since the array is sorted, we used the binary search algorithm.

--> If the target is found still we need to look in the latter half for the last occurrence but this still can happen that there might not be any more of target in the right section so we will store this answer and shift the low pointer to mid + 1 th location.

--> the same step we need to do if the nums[mid] is less than target, therefore we will still look in the latter section of the array.

--> But if nums[mid] > target then we need to look in the first half of the array so we did, high = mid - 1]

--> We will terminate the loop once the low pointer will be equal to or higher than the high pointer.

--> At last we will return our answer.
*/