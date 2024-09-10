// Q4. Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
// Input: head = [1,2,2,1]
// Output: true

// 1. Find the middle of the linked list.
// 2. Reverse the second half of the list.
// 3. Compare the first half with the reversed second half.
package LinkedList.Assignment;

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Ex4_LL {

    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(slow);

        // Step 3: Compare the first half and the reversed second half
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        // Base case: if head is null or only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the linked list
        ListNode newHead = reverseList(head.next);

        // Reverse the pointers
        head.next.next = head;
        head.next = null;

        // Return the new head of the reversed linked list
        return newHead;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Ex4_LL solution = new Ex4_LL();
        if (solution.isPalindrome(head)) {
            System.out.println("The given Linked List is Palindrome");
        } else {
            System.out.println("The given Linked List is not Palindrome");
        }
    }
}
