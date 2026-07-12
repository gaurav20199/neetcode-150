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
    private class HeightBalancedTreeInfo {
        private int height;
        private boolean isBalanced;

        public HeightBalancedTreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

        public int getHeight() {
            return height;
        }

        public boolean isBalanced() {
            return isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        return heightBalancedTree(root).isBalanced();
    }

    private HeightBalancedTreeInfo heightBalancedTree(TreeNode root) {
        if(root==null)
            return new HeightBalancedTreeInfo(0,true);

        HeightBalancedTreeInfo leftHeightBalancedInfo = heightBalancedTree(root.left);
        HeightBalancedTreeInfo rightHeightBalancedInfo = heightBalancedTree(root.right);
        int currentHeight = Math.max(leftHeightBalancedInfo.height,rightHeightBalancedInfo.height)+1;
        boolean isCurrentTreeBalanced = leftHeightBalancedInfo.isBalanced && rightHeightBalancedInfo.isBalanced && Math.abs(leftHeightBalancedInfo.height-rightHeightBalancedInfo.height)<=1;
        return new HeightBalancedTreeInfo(currentHeight,isCurrentTreeBalanced);
    }
}
