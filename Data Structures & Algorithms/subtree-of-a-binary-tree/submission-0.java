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

    public String preordertraversal(TreeNode node){

        if(node == null) return "null";

        StringBuilder sb = new StringBuilder("^");

        sb.append(node.val);

        sb.append(preordertraversal(node.left));
        sb.append(preordertraversal(node.right));

        return sb.toString();
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {


        String fulltree = preordertraversal(root);
        String subtree = preordertraversal(subRoot);

        return (fulltree.contains(subtree));


    }
}
