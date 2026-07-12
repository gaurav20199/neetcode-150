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
    public boolean isValidBST(TreeNode root) {
        return validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean validateBST(TreeNode node, int minValue, int maxValue) {
        if(node==null) 
            return true;
        
        if(node.val<=minValue || node.val>=maxValue)
            return false;
        boolean isLeftSubTreeBST = validateBST(node.left,minValue,node.val);
        boolean isRightSubTreeBST = validateBST(node.right,node.val,maxValue);
        return isLeftSubTreeBST && isRightSubTreeBST;
    }
}
