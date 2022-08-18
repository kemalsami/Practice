
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class Solution {

    private boolean result = true;

    public boolean traverseTree(TreeNode root , long max, long min){

        if(root.val>=max || root.val<=min)
            return false;

        if(root.left!=null){
            result = result && traverseTree(root.left, root.val < max ? root.val : max  , min);
        }

        if(root.right!=null ){
            result = result && traverseTree(root.right, max, root.val > min ? root.val : min);
        }

        return result;
    }

    public boolean isValidBST(TreeNode root) {
        return traverseTree(root, Long.MAX_VALUE, Long.MIN_VALUE);

    }

}
