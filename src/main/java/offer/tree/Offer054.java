package offer.tree;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Offer054 {

  private int k = 0;
  private int value = 0;

  public int kthLargest(TreeNode root, int k) {
//    TreeNode nodeFirst = root;
//    inFirst(nodeFirst);
    if (root != null) {
      value = root.val;
    }
    this.k = k;
    rInOrder(root);
    return value;
//    TreeNode nodeLast = root;
//    inLast(nodeLast);
  }

  private void inFirst(TreeNode node) {
    if (node != null) {
      System.out.println("inFirst = " + node.val);
      inFirst(node.left);
      inFirst(node.right);
    }
  }

  private void rInOrder(TreeNode node) {
    if (node != null) {
      rInOrder(node.right);
      if (k == 0) {
        return;
      } else {
        if(--k == 0) {
          value = node.val;
        }
      }
      rInOrder(node.left);
    }
  }

  private void inLast(TreeNode node) {
    if (node != null) {
      inLast(node.left);
      inLast(node.right);
      System.out.println("inLast = " + node.val);
    }
  }
}
