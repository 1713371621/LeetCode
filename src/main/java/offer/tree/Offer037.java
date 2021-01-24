package offer.tree;

import java.util.*;

public class Offer037 {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "[]";
    }
    List<String> stringList = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode treeNode = queue.poll();
      if (treeNode != null) {
        stringList.add(Integer.toString(treeNode.val));
        if (treeNode.left != null) {
          queue.add(treeNode.left);
        } else {
          queue.add(null);
        }
        if (treeNode.right != null) {
          queue.add(treeNode.right);
        } else {
          queue.add(null);
        }
      } else {
        stringList.add("null");
      }
    }

    int index = stringList.size() - 1;
    for (int i = stringList.size() - 1; i > 0; i--) {
      if (!stringList.get(i).equals("null")) {
        index = i;
        break;
      }
    }
    return Arrays.toString(Arrays.copyOfRange(stringList.toArray(), 0, index + 1));
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    data = data.replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "");
    String[] strings = data.split(",");
    if (strings[0].equals("null") || strings[0].equals("")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int index = 1;
    while (!queue.isEmpty() && index < strings.length) {
      TreeNode treeNode = queue.poll();
      if (!strings[index].equals("null")) {
        treeNode.left = new TreeNode(Integer.parseInt(strings[index]));
        queue.add(treeNode.left);
      }
      index++;
      if (index < strings.length) {
        if (!strings[index].equals("null")) {
          treeNode.right = new TreeNode(Integer.parseInt(strings[index]));
          queue.add(treeNode.right);
        }
        index++;
      }
    }
    return root;
  }
}
