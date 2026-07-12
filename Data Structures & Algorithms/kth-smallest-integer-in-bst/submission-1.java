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
    public class FetchKthElement {
        int kthElementValue;
        int totalNodesCount;
        public FetchKthElement(int kthElementValue, int totalNodesCount) {
            this.kthElementValue = kthElementValue;
            this.totalNodesCount = totalNodesCount;
        }
        public void setKthElementValue(int kthElementValue) {
            this.kthElementValue = kthElementValue;
        }

        public int getKthSmallestValue() {
            return this.kthElementValue;
        }

        public int getTotalNodesCount() {
            return this.totalNodesCount;
        }

        public void setTotalNodesCount(int totalNodesCount) {
            this.totalNodesCount = totalNodesCount;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        FetchKthElement element = new FetchKthElement(0,k);
        inorder(root,k,element);
        return element.getKthSmallestValue();
    }

    public void inorder(TreeNode node, int k,FetchKthElement element) {
        if(node==null)
            return;

        inorder(node.left,k,element);
        if(element.totalNodesCount==0)
            return;
        element.setTotalNodesCount(element.getTotalNodesCount()-1);
        element.setKthElementValue(node.val);    
        inorder(node.right,k,element);
           
    }
}
