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

        if(root == null) return true;

        else{

            int left = getmaxsh(root.left);
            int right = getmaxsh(root.right);

            return Math.abs(left - right) <=1 && isBalanced(root.left) && isBalanced(root.right);
        }
        
    }

    private int getmaxsh(TreeNode node){

        if(node == null) return 0;

        return 1 + Math.max(getmaxsh(node.left), getmaxsh(node.right));
    }
}
