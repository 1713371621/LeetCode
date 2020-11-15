package offer.tree;

public class Offer028 {

  public boolean isSymmetric(TreeNode root) {
    return root == null || recur(root.left, root.right);
  }

  boolean recur(TreeNode L, TreeNode R) {
    if (L == null && R == null) return true;
    if (L == null || R == null || L.val != R.val) return false;
    return recur(L.left, R.right) && recur(L.right, R.left);
  }

  /*public boolean isSymmetric1(TreeNode root) {
    if (root == null) {
      return false;
    }
    inOrder(root);
    String str = stringBuilder.toString();
    stringBuilder=null;
    stringBuilder = new StringBuilder();
    mirror(root);
    inOrder(root);
    String str1 = stringBuilder.toString();
    return str.equals(str1);
  }

  public void mirror(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    TreeNode treeNode1 = treeNode.left;
    treeNode.left = treeNode.right;
    treeNode.right = treeNode1;
    mirror(treeNode.left);
    mirror(treeNode.right);
  }

  StringBuilder stringBuilder = new StringBuilder();

  public void inOrder(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    inOrder(treeNode.left);
    stringBuilder.append(treeNode.val);
    inOrder(treeNode.right);
  }*/
}
