package Tree.Assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex3_Tree {

    // Definition for a binary tree node
    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Method to perform bottom-up level order traversal
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // Track the number of nodes at the current level
            List<Integer> level = new ArrayList<>();

            // Iterate through all the nodes at the current level
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.remove();
                level.add(node.val);

                // Add the children of the node to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(0, level); // Add the level at the beginning to reverse the order
        }
        return result;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        // Instantiate Solution and perform bottom-up level order traversal
        List<List<Integer>> result = levelOrderBottom(root);

        // Print the result
        System.out.println("Bottom-up Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.print(level);
        }
    }
}
