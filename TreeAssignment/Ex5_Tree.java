package Tree.Assignment;

import java.util.LinkedList;
import java.util.Queue;

public class Ex5_Tree {

    // Define TreeNode as a static nested class so it can be used in the main method
    public static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to invert a binary tree
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    // Helper function to print the tree in level-order (level by level)
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                // Add the left and right children of the node to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // Move to a new line after each level
            System.out.println();
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original tree (in-order): ");
        printLevelOrder(root);

        // Invert the binary tree
        invertTree(root);

        System.out.println("\nInverted tree (in-order): ");
        printLevelOrder(root);
    }
}
