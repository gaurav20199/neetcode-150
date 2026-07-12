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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        int leftSubTreeHeight = height(root.left);
        int rightSubTreeHeight = height(root.right);
        return isLeftBalanced && isRightBalanced && Math.abs(leftSubTreeHeight-rightSubTreeHeight)<=1;
    }

    public int height(TreeNode root) {
        if(root==null)
            return 0;

        return Math.max(height(root.left),height(root.right))+1;    
    }
}
