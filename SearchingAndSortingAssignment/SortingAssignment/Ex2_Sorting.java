// Q2. WAP to sort an array in descending order using selection sort
// Input Array {3,5,1,6,0}
// Output Array: {6, 5, 3, 1, 0}
package SearchingAndSorting.SortingAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_Sorting {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }

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
            selectionSort(arr);
            System.out.println("Sorted array is: ");
            System.out.println(Arrays.toString(arr));
        }

    }
}
