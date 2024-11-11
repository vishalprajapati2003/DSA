package Tree.Assignment;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex1_Tree {

    // Definition for a binary tree node
    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true; // Flag for tracking zigzag order

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Add node value in zigzag order
                if (leftToRight) {
                    temp.add(node.val);
                } else {
                    temp.addFirst(node.val);
                }

                // Add child nodes to queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Add current level to result and flip the zigzag direction
            res.add(temp);
            leftToRight = !leftToRight;
        }
        return res;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Instantiate Solution and perform zigzag level order traversal
        List<List<Integer>> result = zigzagLevelOrder(root);

        // Print the result
        System.out.println("Zigzag Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
