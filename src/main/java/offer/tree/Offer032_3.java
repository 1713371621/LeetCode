package offer.tree;

import java.util.*;

public class Offer032_3 {
  public static void main(String[] args) {
    Offer032_3 offer032_3 = new Offer032_3();
    TreeNode root = new TreeNode(1);
    TreeNode treeNodeL = new TreeNode(2);
    TreeNode treeNodeR = new TreeNode(3);
    root.left = treeNodeL;
    root.right = treeNodeR;

    List<List<Integer>> lists = offer032_3.levelOrder(root);
    for (List<Integer> integers : lists) {
      System.out.println(Arrays.toString(integers.toArray()));
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    if (root != null) queue.add(root);
    boolean reverse = false;
    while (!queue.isEmpty()) {
      LinkedList<Integer> integers = new LinkedList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = queue.poll();
        if (treeNode != null) {
          if (reverse) {
            integers.addFirst(treeNode.val);
          } else {
            integers.addLast(treeNode.val);
          }
          if (treeNode.left != null) queue.add(treeNode.left);
          if (treeNode.right != null) queue.add(treeNode.right);
        }
      }
      result.add(integers);
      reverse = !reverse;
    }
    return result;
  }
}
