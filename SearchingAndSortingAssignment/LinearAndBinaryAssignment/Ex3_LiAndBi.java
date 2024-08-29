// Q3. Given a sorted binary array, efficiently count the total number of 1’s in it.
// Input 1: arr = [0 0 0 0 1 1 1 1 1 1]
// Output 1: 6
package SearchingAndSorting.LinearAndBinaryAssignment;

import java.util.Scanner;

public class Ex3_LiAndBi {
    public static int numberOf1s(int[] nums, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (nums.length - low);
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

            System.out.println("The number of one's in the given array is/are: " + numberOf1s(arr, 0, m - 1));
        }
    }
}
