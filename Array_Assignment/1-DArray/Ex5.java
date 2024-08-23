// Q5: Given an array. Find the first peak element in the array. A peak element is an element that is greater than
// its just left and just right neighbor.

// Input 1: arr[] = {1,3,2,6,5}
// Output 1: 6
// Input 2: arr[] = {1 4,7,3,2,6,5}
// Output 1: 7
package Assignment;

public class Ex5 {
    public static void main(String[] args) {

        int[] arr = { 1, 1, 3, 4, 2, 3, 5, 7, 1 };
        // int[] arr = { 1, 1, 1, 1, 1, 1, 1 };

        // Check if array has fewer than 3 elements
        if (arr.length < 3) {
            System.out.println("No peak element found");
            return;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                System.out.print(arr[i]);
                return;
            }
        }

        // This will only run if no peak element is found
        System.out.println("No peak element found");
    }
}