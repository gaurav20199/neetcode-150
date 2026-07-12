/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);  
    }

    public TreeNode invertTreeHelper(TreeNode currNode) {
        if(currNode==null)
            return currNode;

        TreeNode leftNode = invertTreeHelper(currNode.left);
        TreeNode rightNode = invertTreeHelper(currNode.right);
        currNode.right = leftNode;
        currNode.left = rightNode;
        return currNode;

    }
}
