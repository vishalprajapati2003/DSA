/* Given an integer array, duplicates are present in it in a way that all duplicates appear an even number of times except one which appears an odd number of times. Find that odd appearing element in linear time and without using any extra memory.

example:
Input : arr[] = [4, 3, 6, 2, 6, 4, 2, 3, 4, 3, 3]
Output : The odd occurring element is 4.
*/


/*
1. a ^ a = 0 (XOR of a number with itself is 0)
2. a ^ 0 = a (XOR of a number with 0 is the number itself)
3. XOR is commutative and associative: The order in which you XOR multiple numbers does not matter.
 */
package SearchingAndSorting.NumberSystemAssignment;

public class Ex5_Number {
    public static int findOddOccurringElement(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num; // XOR all the elements
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 4, 4, 4, 2, 5, 5}; // Example array
        System.out.println("The element that appears an odd number of times is: " + findOddOccurringElement(arr));
    }
}

/*
Step-by-Step XOR Operations:

    result = 0 ^ 2 → result = 2
    result = 2 ^ 3 → result = 1
    result = 1 ^ 5 → result = 4
    result = 4 ^ 4 → result = 0
    result = 0 ^ 5 → result = 5
    result = 5 ^ 3 → result = 6
    result = 6 ^ 4 → result = 2
    result = 2 ^ 4 → result = 6
    result = 6 ^ 4 → result = 2
    result = 2 ^ 4 → result = 6
    result = 6 ^ 2 → result = 4
    result = 4 ^ 5 → result = 1
    result = 1 ^ 5 → result = 4
*/
/*
Time Complexity: O(n) where n is the number of elements in the array.
Space Complexity: O(1) since no extra memory is used apart from a single variable to store the result.
*/