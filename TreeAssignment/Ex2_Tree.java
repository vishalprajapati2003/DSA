package Tree.Assignment;

public class Ex2_Tree {

    // Definition for a binary tree node
    static class TreeNode {

        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Using BFS
// class Solution {
// public boolean isCompleteTree(TreeNode root) {
// if (root == null)
// return true;
// Queue<TreeNode> q = new LinkedList<>();
// q.add(root);
// // To track if we've encountered any null nodes
// boolean foundNull = false;
// while (!q.isEmpty()) {
// TreeNode node = q.remove();
// if (node == null) {
// // If we find a null node, set foundNull to true
// foundNull = true;
// } else {
// // If we encounter a non-null node after finding a null node, the tree is not
// // complete
// if (foundNull)
// return false;
// // Add left and right children to the queue (nulls included)
// q.add(node.left);
// q.add(node.right);
// }
// }
// // If we finish the loop without returning false, the tree is complete
// return true;
// }
// }
    

    // Using DFS
    // Helper to count nodes in the tree
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // DFS method to check completeness by verifying each node's index
    public static boolean isCompleteDFS(TreeNode root, int index, int nodeCount) {
        // If we reach a null node, it's valid
        if (root == null) {
            return true;
        }
        // If the index is out of bounds, it's not complete
        if (index > nodeCount) {
            return false;
        }
        // Check left and right subtrees with updated indices
        return isCompleteDFS(root.left, 2 * index, nodeCount)
                && isCompleteDFS(root.right, 2 * index + 1, nodeCount);
    }

    // Method to check if the binary tree is complete
    public static boolean isCompleteTree(TreeNode root) {
        // Get the total number of nodes
        int totalNodes = countNodes(root);
        return isCompleteDFS(root, 1, totalNodes);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        // Note: Not adding a right child for root.right to keep it a complete tree

        // Check if the tree is complete
        boolean isComplete = isCompleteTree(root);

        // Print the result
        System.out.println("Is the binary tree complete? " + isComplete);
    }
}
