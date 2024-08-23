// Q4: Write a program to find out the second largest element in a given array.

// Input 1: arr[] = {34,21,54,65,43}
// Output 1: 54
// Input 1: arr[] = {4,3,6,7,1}
// Output 1: 6

package Assignment;

public class Ex4 {
    public static void main(String[] args) {
        int[] arr = { 34, 21, 54, 65, 43 };
        int arr_size = arr.length;
        int i, first, second;

        // There should be at least two elements
        if (arr_size < 2) {
            System.out.printf(" Invalid Input ");
            return;
        }
        first = second = Integer.MIN_VALUE;

        // Find the largest element
        for (i = 0; i < arr_size; i++) {
            first = Math.max(first, arr[i]);
        }

        // Find the second largest element
        for (i = 0; i < arr_size; i++) {
            if (arr[i] != first)
                second = Math.max(second, arr[i]);
        }
        if (second == Integer.MIN_VALUE)
            System.out.printf("There is no second " + "largest element\n");
        else
            System.out.println("The first largest element " + "is " + first);
        System.out.printf("The second largest element " + "is %d\n", second);
    }
}

// package Assignment;

// public class Ex4 {
// public static void main(String[] args) {
// int[] arr = { 34, 21, 54, 65, 43 };
// int arr_size = arr.length;

// // There should be at least two elements
// if (arr_size < 2) {
// System.out.println("Invalid Input");
// return;
// }

// int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

// // Iterate through the array to find the largest and second largest elements
// for (int i = 0; i < arr_size; i++) {
// if (arr[i] > first) {
// // Update second before updating first
// second = first;
// first = arr[i];
// } else if (arr[i] > second && arr[i] != first) {
// second = arr[i];
// }
// }

// if (second == Integer.MIN_VALUE) {
// System.out.println("There is no second largest element");
// } else {
// System.out.println("The largest element is " + first);
// System.out.println("The second largest element is " + second);
// }
// }
// }
