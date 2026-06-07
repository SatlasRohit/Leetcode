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

    /*
     We use an array to store references to all nodes by their value.
     Constraint guarantees node values ≤ 100000.
     
     nodes[v] will store the TreeNode with value v.
    */
    private static final TreeNode[] nodes = new TreeNode[100001];

    public TreeNode createBinaryTree(int[][] descriptions) {

        /*
         First pass:
         For every parent value (x[0]), mark nodes[x[0]] as null.
         This helps identify the root later.
         The root is the node that never appears as a child.
        */
        for (int[] x : descriptions) {
            nodes[x[0]] = null;
        }

        /*
         Second pass:
         Create TreeNode objects for all child values (x[1]).
         This guarantees that child nodes already exist
         before linking them to parents.
        */
        for (int[] x : descriptions) {
            nodes[x[1]] = new TreeNode(x[1]);
        }

        TreeNode root = null;

        /*
         Third pass:
         - Create parent node if it does not exist
         - Attach child node as left or right
        */
        for (int[] x : descriptions) {

            /*
             If parent node does not exist yet,
             create it and mark it as root.
             (Only the actual root will satisfy this condition)
            */
            if (nodes[x[0]] == null) {
                root = nodes[x[0]] = new TreeNode(x[0]);
            }

            /*
             x[2] == 1 → child is left child
             x[2] == 0 → child is right child
            */
            if (x[2] == 1) {
                nodes[x[0]].left = nodes[x[1]];
            } else {
                nodes[x[0]].right = nodes[x[1]];
            }
        }

        // Return the root of the constructed binary tree
        return root;
    }
}