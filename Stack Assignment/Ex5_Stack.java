package Stack.Assignment;

import java.util.Stack;
public class Ex5_Stack {

    // Brute Force Approach
    // Time complexity : O(n^2)
    // Space complexity: O(1)
    // public static int[] dailyTemperatures(int[] temperatures) {

    //     int[] ans = new int[temperatures.length];
    //     for (int i = 0; i < temperatures.length; i++) {

    //         for (int j = i + 1; j < temperatures.length; j++) {
    //             if (temperatures[j] > temperatures[i]) {
    //                 ans[i] = j - i; // store the difference
    //                 break;
    //             }
    //         }
    //     }
    //     return ans;
    // }

    // Optimized Approach
    // Time complexity : O(n)
    // Space complexity: O(n)
    // Stack give the 82ms in leetcode

    // public static int[] dailyTemperatures(int[] temperatures) {

    //     int[] ans = new int[temperatures.length];
    //     Stack<Integer> s = new Stack<>();
    //     for (int i = 0; i < temperatures.length; i++) {
    //         while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
    //             ans[s.peek()] = i - s.peek();
    //             s.pop();
    //         }
    //         s.push(i);
    //     }
    //     return ans;
    // }

    // Using a fixed-size array as a stack it will give the 8ms in leetcode
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int[] stack = new int[n]; // Using a fixed-size array as a stack
        int top = -1; // Stack pointer

        for (int i = 0; i < n; i++) {
            // Resolve warmer temperatures while the stack is not empty and current is
            // warmer
            while (top >= 0 && temperatures[stack[top]] < temperatures[i]) {
                int index = stack[top--]; // Pop the index from the stack
                ans[index] = i - index; // Calculate the number of days until a warmer temperature
            }
            stack[++top] = i; // Push the current index onto the stack
        }

        return ans; // Return the result array
    }

    public static void main(String[] args) {

        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        int[] ans = dailyTemperatures(temperatures);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}
