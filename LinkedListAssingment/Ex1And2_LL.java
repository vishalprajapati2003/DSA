// Q1. Given a linked list and a key ‘X‘ in, the task is to check if X is present in the linked list or not.
//Input: 14->21->11->30->10, X = 14
//Output: Yes
// Explanation: 14 is present in the linked list.

// Q2. Insert a node at the given position in a linked list. We are given a pointer to a node, and the new node is inserted after the given node.
// Input: LL = 1 -> 2 -> 4 -> 5 -> 6  pointer = 2 value = 3.
// Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
package LinkedList.Assignment;

public class Ex1And2_LL {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    // Inserts a new node at the end of the list to preserve sorted order
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    //Q1. Checks whether the value x is present in linked list
    public boolean search(Node head, int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x)
                return true; // data found
            current = current.next;
        }
        return false; // data not found
    }

    //Q2. Insert a node at the given position in a linked list.
    public void push_At(int newElement, int position) {
        Node newNode = new Node(newElement);
        if(position < 1) {
            System.out.println("Invalid position");
        }else if (position==1) {
            newNode.next = head;
            head = newNode;
        }else {
            Node temp = head;
            for(int i=1; i<position-1; i++) {
                if(temp!=null) {
                    temp = temp.next;
                }
            }
            if(temp!=null) {
                newNode.next = temp.next;
                temp.next = newNode;
            }else {
                System.out.println("The Previous node is null");
            }
        }
    }

    // Prints the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Ex1And2_LL llist = new Ex1And2_LL();

        llist.append(1);
        llist.append(2);
        llist.append(4);
        llist.append(5);
        llist.append(6);

        if (llist.search(llist.head, 4))
            System.out.println("Search found");
        else
            System.out.println("Search not found");
        
        System.out.println("Inserting at position 3");
        llist.push_At(3, 3);
        llist.printList();
    }
}
