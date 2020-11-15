package offer.tree;

import java.util.*;

public class Offer032_1 {
  public int[] levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();
    if (root != null) queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node != null) {
        result.add(node.val);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
    }
    int[] ints = new int[result.size()];
    int index = 0;
    for (int i: result) {
      ints[index] = i;
      index ++;
    }
    return ints;
  }
}
