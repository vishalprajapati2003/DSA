// Q1. Find the minimum sum of Products of two arrays of the same size, given that k modifications are allowed on the first array. In each modification, one array element of the first array can either be increased or decreased by 2.
package Greedy.Assignment;

// import java.util.*;

public class MinSumProduct {

    // Function to find the minimum sum of products after k modifications
    public static int minproduct(int a[], int b[], int n, int k) {
        int CurrMaxdiff = 0, res = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            int pro = a[i] * b[i];
            res = res + pro;
            if (pro < 0 && b[i] < 0)
                temp = (a[i] + 2 * k) * b[i];

            else if (pro < 0 && a[i] < 0)
                temp = (a[i] - 2 * k) * b[i];
            else if (pro > 0 && a[i] < 0)
                temp = (a[i] + 2 * k) * b[i];
            else if (pro > 0 && a[i] > 0)
                temp = (a[i] - 2 * k) * b[i];

            int diff = Math.abs(pro - temp);
            if (diff > CurrMaxdiff)
            CurrMaxdiff = diff;
        }
        return res - CurrMaxdiff;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2,-3 };
        int b[] = { -2, 3, -5 };
        int n = 3, k = 5;
        System.out.println(minproduct(a, b, n, k));
    }
}