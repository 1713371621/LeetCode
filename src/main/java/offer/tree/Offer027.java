package offer.tree;

public class Offer027 {
  public static void main(String[] args) {

  }

  public TreeNode mirrorTree(TreeNode root) {
    mirror(root);
    return root;
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
}
