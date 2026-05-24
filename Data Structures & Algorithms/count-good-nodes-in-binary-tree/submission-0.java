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

        return countgoodnodes(root, Integer.MIN_VALUE);
    }

    public int countgoodnodes(TreeNode node, int maxvalsofar){

        if(node == null) return 0;

        int count = 0;

        if(node.val >= maxvalsofar){

            count = 1;
            maxvalsofar = node.val;
        }        

        count += countgoodnodes(node.left, maxvalsofar);
        count += countgoodnodes(node.right, maxvalsofar);

        return count;
        
    }
}
