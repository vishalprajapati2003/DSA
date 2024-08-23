// Q2: write a program to print the elements above the secondary diagonal in a user inputted square matrix.

// Input 1: 
// 1 2 3    00 01 02
// 4 5 6    10 11 12
// 7 8 9    20 21 22

// Output 1:
// 1 2 4

// Approach:
// The secondary diagonal is highlighted
// The elements that lie above the secondary diagonal are also highlighted.
//In all these blue cells one thing is common
// The sum of (i + j)th coordinate is always lesser than the column number - 1>
//So 0 + 0 < 3 , 0 + 1 < 3 , 0 + 2 < 3 , 1 + 0 < 3 and so on.
// We have used this condition to print all those elements.

// Time Complexity: O(m*n)
// Space Complexity: O(1)
package Assignment;

import java.util.Scanner;

public class Ex2 {
    public static void main(String args[]) {

        int m, n;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of rows : ");
        m = sc.nextInt();
        System.out.print("enter the number of column : ");
        n = sc.nextInt();
        int arr[][] = new int[m][n];

        int i, j;

        System.out.println("enter the  matrix element : ");
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Elements above secondary diagonal are as follows : ");
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i + j < m - 1)
                    System.out.print(arr[i][j] + "  ");
            }
        }
    }
}
