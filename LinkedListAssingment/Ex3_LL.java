package LinkedList.Assignment;

public class Ex3_LL {
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

    // Function to remove duplicates from sorted linked list
    public void removeDuplicates() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // skip the duplicate node
            } else {
                current = current.next; // move to the next distinct node
            }
        }
    }
     // Function to remove duplicates from Unsorted linked list
    public void removeDuplicatesUnsorted() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        Node temp=null;
        while (current != null && current.next != null) {
            temp = current;
            while (temp.next != null) {
                if (current.data == temp.next.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            current = current.next;
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
        Ex3_LL llist = new Ex3_LL();

        // Add elements to the linked list
        llist.append(1);
        llist.append(1);
        llist.append(2);
        llist.append(3);
        llist.append(3);

        System.out.println("Original List:");
        llist.printList();

        // Remove duplicates
        llist.removeDuplicates();

        System.out.println("List after removing duplicates:");
        llist.printList();
    }
}
