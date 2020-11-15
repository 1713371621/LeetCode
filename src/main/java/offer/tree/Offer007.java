package offer.tree;

import java.util.HashMap;
import java.util.Stack;

public class Offer007 {
  public static void main(String[] args) {

    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};

    Offer007 offer007 = new Offer007();
    TreeNode treeNode = offer007.buildTree(preorder, inorder);

    preOrderTraversal(treeNode);
  }

  static void preOrderTraversal(TreeNode treeNode) {

    if (treeNode == null) {
      System.out.print("0; ");
      return;
    }
    System.out.print(treeNode.val + "; ");
    preOrderTraversal(treeNode.left);
    preOrderTraversal(treeNode.right);
  }

  void preOrderTraversalWithStack(TreeNode treeNode) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = treeNode;
    while (node != null || !stack.empty()) {
      while (node != null) {
        System.out.print(node.val + "; ");
        stack.push(node);
        node = node.left;
      }

      if (!stack.empty()) {
        node = stack.pop();
        node = node.right;
      }
    }
  }

  HashMap<Integer, Integer> map = new HashMap<>();
  int[] preorder;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
      System.out.println("inorder[i]: " + inorder[i] + ", i = " + i);
    }
    return recursive(0, 0, inorder.length - 1);
  }

  public TreeNode recursive(int rootIndex, int inLeftIndex, int inRightIndex) {
    if (inLeftIndex > inRightIndex) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[rootIndex]);
    int idx = map.get(preorder[rootIndex]);
    root.left = recursive(rootIndex + 1, inLeftIndex, idx - 1);
    root.right = recursive(rootIndex + (idx - 1 - inLeftIndex + 1) + 1, idx + 1, inRightIndex);
    return root;
  }
}

