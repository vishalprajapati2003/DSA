// Q5. Given two numbers represented by two lists, write a function that returns the sum list. The sum list is a list representation of the addition of two input numbers.
// Input:
// List1:  5->6->3  // Represents number 563
// List2: 8->4->2   // Represents number 842

// Output:
// Resultant list: 1->4->0->5 // Represents number 1405
// Explanation: 563 + 842 = 1405

// Steps:
// 1. Traverse both linked lists from the least significant digit to the most significant digit (which are typically stored in reverse order in the lists).

// 2. Add the corresponding digits, including any carry from the previous addition.
// 3. Store the result in a new linked list.
// 4. Continue this process until both lists have been traversed and there is no carry left.
package LinkedList.Assignment;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Ex5_LL {

    // Function to add two numbers represented by linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1, q = l2, current = dummyNode;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;

            // Update carry for the next iteration
            carry = sum / 10;

            // Create the next node with the digit of the current sum
            current.next = new ListNode(sum % 10);

            // Move to the next node
            current = current.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }

        // If there is any carry left, add it as a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // List1: 5 -> 6 -> 3 (Represents the number 563)
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(3);

        // List2: 8 -> 4 -> 2 (Represents the number 842)
        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(2);

        Ex5_LL solution = new Ex5_LL();
        ListNode sum = solution.addTwoNumbers(l1, l2); // Should return 1 -> 4 -> 0 -> 5

        // Print the sum list
        while (sum != null) {
            System.out.print(sum.val);
            if (sum.next != null)
                System.out.print(" -> ");
            sum = sum.next;
        }
        // Expected Output: 1 -> 4 -> 0 -> 5 (which represents the number 1405)
    }
}