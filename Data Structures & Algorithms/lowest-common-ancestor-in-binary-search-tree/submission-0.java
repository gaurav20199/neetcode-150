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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null || q==null || root==null)
            return null;
        return findLCA(root,p,q);
    }

    public TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if(node==null)
            return node;
        if(node.val==p.val || node.val==q.val)
            return node;
        TreeNode leftNode = findLCA(node.left,p,q);
        TreeNode rightNode = findLCA(node.right,p,q);
        if(leftNode!=null && rightNode!=null)
            return node;

        return leftNode!=null?leftNode:rightNode;    

    }
}
