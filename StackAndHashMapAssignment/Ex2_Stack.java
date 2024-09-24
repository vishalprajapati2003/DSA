// Q2. Given an encoded string, return its decoded string. The encoding rule is: k[encoded_string],where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
package Stack.Assignment;
import java.util.*;
public class Ex2_Stack {
    public static String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String curString = "";
        int curNum = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                // Push current string and number onto their respective stacks
                stringStack.push(curString);
                numStack.push(curNum);
                // Reset current string and number
                curString = "";
                curNum = 0;
            } else if (c == ']') {
                // Pop number and previous string from stacks
                int num = numStack.pop();
                String prevString = stringStack.pop();
                // Repeat current string 'num' times and concatenate with previous string
                curString = prevString + curString.repeat(num);
            } else if (Character.isDigit(c)) {
                // Build the current number
                curNum = curNum * 10 + (c - '0');
            } else {
                // Append current character to curString
                curString += c;
            }
        }
        return curString;
    }

    public static void main(String[] args) {
        String s = "2[a2[bc]]";
        String decodedString = decodeString(s);
        System.out.println(decodedString);
    }
}
