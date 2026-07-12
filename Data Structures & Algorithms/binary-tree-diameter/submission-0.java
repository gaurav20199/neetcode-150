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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        fetchHeight(root);
        return diameter;
    }

    public int fetchHeight(TreeNode node) {
        if(node==null)
            return 0;  

        int maxLeftHeight = fetchHeight(node.left);
        int maxRightHeight = fetchHeight(node.right);

        diameter = Math.max(diameter,maxLeftHeight+maxRightHeight);

        return Math.max(maxLeftHeight,maxRightHeight)+1;


    }
}
