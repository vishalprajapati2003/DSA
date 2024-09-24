// We are given an array asteroids of integers representing asteroids in a row. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed. Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

// Example 1:
// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

// Example 2:
// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.

package Stack.Assignment;

import java.util.*;

public class Ex4_Stack {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); // Stack to store surviving asteroids

        for (int asteroid : asteroids) {
            boolean shouldPush = true; // Flag to determine if we should push the asteroid

            while (shouldPush && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                // Collision case
                if (stack.peek() == -asteroid) {
                    stack.pop(); // Both asteroids destroy each other
                    shouldPush = false; // The current asteroid is also destroyed
                } else if (stack.peek() < -asteroid) {
                    stack.pop(); // The positive asteroid is destroyed
                } else {
                    // The current negative asteroid is destroyed
                    shouldPush = false;
                }
            }

            if (shouldPush) {
                stack.push(asteroid); // Push the current asteroid if still alive
            }
        }

        // Convert stack to an array
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i); // Fill result from stack
        }

        return result;
    }

    // OR using Array
    // Using Array time is 2ms But using Stack time is 6ms
    // public static int[] asteroidCollision(int[] asteroids) {
    // int n = asteroids.length;
    // int[] result = new int[n]; // Allocate the maximum possible size
    // int top = -1; // Stack pointer

    // for (int asteroid : asteroids) {
    // boolean shouldPush = true; // Flag to determine if we should push the
    // asteroid

    // // Handle collisions for the current asteroid
    // while (shouldPush && asteroid < 0 && top >= 0 && result[top] > 0) {
    // int topAsteroid = result[top]; // Get the top asteroid

    // if (topAsteroid == -asteroid) {
    // // Both asteroids destroy each other
    // top--; // Remove the top asteroid
    // shouldPush = false; // The current asteroid is also destroyed
    // } else if (topAsteroid < -asteroid) {
    // // The positive asteroid is destroyed
    // top--; // Remove the top asteroid
    // } else {
    // // The current negative asteroid is destroyed
    // shouldPush = false;
    // }
    // }

    // // Push the current asteroid if it survives
    // if (shouldPush) {
    // result[++top] = asteroid; // Increment top and push the current asteroid
    // }
    // }

    // // Create a new array to return the result
    // return Arrays.copyOf(result, top + 1); // Resize to the number of surviving
    // asteroids
    // }

    public static void main(String[] args) {
        int[] asteroids1 = { 5, 10, -5 };
        System.out.println(Arrays.toString(asteroidCollision(asteroids1)));
    }
}
