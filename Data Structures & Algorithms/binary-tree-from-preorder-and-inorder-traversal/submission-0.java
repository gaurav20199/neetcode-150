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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode createTree(int []preorder,int []inorder, int psi, int pei, int isi, int iei) {
        if(isi<0 || isi>=inorder.length || iei<0 || iei>=inorder.length || isi>iei)
            return null;
        if(psi<0 || psi>=preorder.length || pei<0 || pei>=preorder.length || psi>pei)
            return null;

        int nodeValue = preorder[psi];
        int idx = -1;
        for(int i=isi;i<inorder.length;i++) {
            if(inorder[i]==nodeValue) {
                idx = i;
                break;
            }
        }
        int firstRightElementIndexForCurrNode = psi+idx-isi;
        TreeNode node = new TreeNode(nodeValue);
        node.left = createTree(preorder,inorder,psi+1,firstRightElementIndexForCurrNode,isi,idx-1);
        node.right = createTree(preorder,inorder,firstRightElementIndexForCurrNode+1,pei,idx+1,iei);
        return node;


    }
}
