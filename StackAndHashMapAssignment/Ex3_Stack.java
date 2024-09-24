// Q3. You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record. You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
// An integer x: Record a new score of x.
// '+': Record a new score that is the sum of the previous two scores.
// 'D': Record a new score that is the double of the previous score.
// 'C': Invalidate the previous score, removing it from the record.
// Return the sum of all the scores on the record after applying all the operations.
package Stack.Assignment;
import java.util.Stack;
public class Ex3_Stack {
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("C")) {
                // Remove the last score
                stack.pop();
            } else if (op.equals("D")) {
                // Double the last score
                stack.push(2 * stack.peek());
            } else if (op.equals("+")) {
                // Sum of the last two scores
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top); // Push the previous top back
                stack.push(newTop);
            } else {
                // Convert string to integer and push to the stack
                stack.push(Integer.parseInt(op));
            }
        }
        // Calculate the sum of all scores
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] operations = { "5", "2", "C", "D", "+" };
        int result = calPoints(operations);
        System.out.println(result);
    }
}
