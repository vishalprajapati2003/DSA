// Q3. WAP to sort an array in decreasing order using insertion sort
// Input Array {3,5,1,6,0}
// Output Array: {6, 5, 3, 1, 0}
package SearchingAndSorting.SortingAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3_Sorting {
    public static void insertionSort(int[] arr) {

        // for (int i = 1; i < arr.length; i++) {
        //     int j = i;
        //     while (j > 0 && arr[j] > arr[j - 1]) {
        //         // swap the elements between arr[j] and arr[j-1]
        //         int temp = arr[j];
        //         arr[j] = arr[j - 1];
        //         arr[j - 1] = temp;

        //         j--;
        //     }
        // }

        // Another way of doing insertion sort

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements of array");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            insertionSort(arr);
            System.out.println("Sorted array is: ");
            System.out.println(Arrays.toString(arr));
        }

    }
}
