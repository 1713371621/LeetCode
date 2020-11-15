package offer.tree;

import java.util.ArrayList;
import java.util.List;

public class Offer008 {

  public static void main(String[] args) {
    Offer008 offer008 = new Offer008();
  }

  List<TreeLinkNode> treeLinkNodes = new ArrayList<>();

  public TreeLinkNode GetNext(TreeLinkNode pNode) {
    TreeLinkNode treeLinkNode = pNode;
    while (treeLinkNode.next != null) {
      treeLinkNode = treeLinkNode.next;
    }
    inOrder(treeLinkNode);
    for (int i = 0; i < treeLinkNodes.size(); i++) {
      if (pNode == treeLinkNodes.get(i)) {
        return i == treeLinkNodes.size() - 1 ? null : treeLinkNodes.get(i + 1);
      }
    }
    return null;
  }

  private void inOrder(TreeLinkNode treeLinkNode) {
    if (treeLinkNode == null) {
      return;
    }

    inOrder(treeLinkNode.left);
    treeLinkNodes.add(treeLinkNode);
    inOrder(treeLinkNode.right);
  }
}

