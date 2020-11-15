package offer.tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Offer026 {
  public static void main(String[] args) {
    System.out.println("ABC".contains("C"));
  }

  public boolean isSubStructure(TreeNode A, TreeNode B) {
    return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
  }

  boolean recur(TreeNode A, TreeNode B) {
    if (B == null) return true;
    if (A == null || A.val != B.val) return false;
    return recur(A.left, B.left) && recur(A.right, B.right);
  }

  List<Integer> preOrder(TreeNode treeNode) {
    List<Integer> treeList = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    while (treeNode != null || !stack.empty()) {
      while (treeNode != null) {
        treeList.add(treeNode.val);
        stack.push(treeNode);
        treeNode = treeNode.left;
      }

      if (!stack.empty()) {
        treeNode = stack.pop();
        // inOrder; treeList.add(treeNode.val);
        treeNode = treeNode.right;
      }
    }
    return treeList;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}


