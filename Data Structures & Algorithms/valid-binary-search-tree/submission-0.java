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
    private class BSTStructure {
        boolean isValidNode;
        int maxValue;
        int minValue;

        public BSTStructure(boolean isValidNode, int maxVal, int minVal) {
            this.isValidNode = isValidNode;
            this.maxValue = maxVal;
            this.minValue = minVal;
        }

    }

    public boolean isValidBST(TreeNode root) {
        return validateBST(root).isValidNode;
    }

    public BSTStructure validateBST(TreeNode node) {
        if(node==null) {
            return new BSTStructure(true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        BSTStructure leftStructure = validateBST(node.left);
        BSTStructure rightStructure = validateBST(node.right);
        boolean isNodeHoldingBSTProperty = leftStructure.maxValue<node.val && rightStructure.minValue>node.val;
        boolean isValidNode = leftStructure.isValidNode && rightStructure.isValidNode && isNodeHoldingBSTProperty;
        int actualMin = Math.min(node.val, leftStructure.minValue);
        int actualMax = Math.max(node.val, rightStructure.maxValue);
        return new BSTStructure(isValidNode, actualMax, actualMin);
    }
}
