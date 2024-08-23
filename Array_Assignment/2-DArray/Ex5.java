// Q5: Write a function which accepts a 2D array of integers and its size as arguments and displays the elements of middle row and the elements of middle column. Printing can be done in any order. [Assuming the 2D Array to be a square matrix with odd dimensions i.e. 3x3, 5x5, 7x7 etc...]

// Input: 1 2 3
//        4 5 6
//        7 8 9
// Output: 2 5 8 4 6

// Time Complexity : O(m*m)
// Space Complexity : O(1)
package Assignment;

import java.util.Scanner;

public class Ex5 {
    public static void main(String args[]) {

        int m;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of rows : ");
        m = sc.nextInt();

        int arr[][] = new int[m][m];

        int i, j;

        System.out.println("enter the  matrix element : ");
        for (i = 0; i < m; i++) {
            for (j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("The elements  of the middle row and middle column are as follows : ");

        for (i = 0; i < m; i++)
            System.out.print(arr[i][m / 2] + "  ");
        for (j = 0; j < m; j++) {
            if (j == m / 2) {
                continue;
            }
            System.out.print(arr[m / 2][j] + "  ");
        }
    }
}
