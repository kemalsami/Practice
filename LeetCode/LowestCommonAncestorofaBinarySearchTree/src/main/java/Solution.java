import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }


/**
 * BST olduğunu bildiğimize göre lowest common ancestor değeri q ve q değeri arasında olmak zorundadır
 *
 * p ve q değeri root değerinden küçükse o zaman tree üzerinde sağa doğru gidilmelidir
 * p ve q değeri root değerinden büyükse o zaman tree üzerinde sola doğru gidilmelidir
 *
 * root değer p ile q arasında ise sonuç bu değer olacaktır
 *
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if( (p.val<=root.val && root.val<=q.val) || (p.val>=root.val && root.val>=q.val) ){
            return root;
        }else if(p.val<= root.val && q.val<=root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val> root.val && q.val>root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public TreeNode lowestCommonAncestor_v1(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > q.val){
            if(q.val<=root.val && root.val<=p.val ){
                return root;
            }else if(root.val >= p.val ){
                return lowestCommonAncestor(root.left, p , q);
            }else if(root.val <= q.val){
                return lowestCommonAncestor(root.right, p , q);
            }
        }else {
            if(p.val<=root.val && root.val<=q.val ){
                return root;
            }else if(root.val >= p.val ){
                return lowestCommonAncestor(root.left, p , q);
            }else if(root.val <= q.val){
                return lowestCommonAncestor(root.right, p , q);
            }
        }

        return root;
    }
}
