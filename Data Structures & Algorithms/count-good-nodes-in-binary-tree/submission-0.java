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
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
       return goodNodesCount(root,root.val); 
    }

    public int goodNodesCount(TreeNode node, int max) {
        if(node==null)
            return 0;
        
        int leftVal = node.left==null?Integer.MIN_VALUE:node.left.val;
        int rightVal = node.right==null?Integer.MIN_VALUE:node.right.val;
        int lAns = goodNodesCount(node.left,Math.max(node.val,Math.max(max,leftVal)));
        int rAns = goodNodesCount(node.right,Math.max(node.val,Math.max(max,rightVal)));
        if(node.val>=max)
            return lAns+rAns+1;

        return lAns+rAns;    
    }
}
