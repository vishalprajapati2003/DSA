// Q1. Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//I/P: matrix=[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//O/P: 6
package Stack.Assignment;

import java.util.*;

public class Ex1_Stack {
    public static int[] nextsmaller(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (s.peek() != -1 && arr[s.peek()] >= curr) {
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

    public static int[] prevsmaller(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);

        int[] ans1 = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            while (s.peek() != -1 && arr[s.peek()] >= curr) {
                s.pop();
            }
            ans1[i] = s.peek();
            s.push(i);
        }
        return ans1;
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] next = new int[n];
        next = nextsmaller(heights, n);

        int[] prev = new int[n];
        prev = prevsmaller(heights, n);

        int area = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int l = heights[i];

            if (next[i] == -1) {
                next[i] = n;
            }
            int b = next[i] - prev[i] - 1;
            int newarea = l * b;
            area = Math.max(area, newarea);
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
        int n = arr.length;
        int m = arr[0].length;

        // Compute area for first Row
        int area = largestRectangleArea(arr[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Row update by adding previous rows value
                if (arr[i][j]!=0) {
                    arr[i][j] = arr[i][j] + arr[i - 1][j];
                }
                else{
                    arr[i][j] = 0;
                }
            }
            // Entire row is updated row
            area = Math.max(area, largestRectangleArea(arr[i]));
        }
        System.out.println("Area of the largest rectangle is " + area);
    }
}
