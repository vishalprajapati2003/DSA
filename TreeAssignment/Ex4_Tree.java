package Tree.Assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ex4_Tree {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to return list containing elements of left view of binary tree
    public static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Iterate through each level
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.remove();

                // Capture the first node of each level
                if (i == 0) {
                    result.add(node.data);
                }

                // Add left and right children to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Left view of the binary tree:");
        ArrayList<Integer> leftView = leftView(root);

        // Print the left view of the tree
        for (int value : leftView) {
            System.out.print(value + " ");
        }
    }
}
