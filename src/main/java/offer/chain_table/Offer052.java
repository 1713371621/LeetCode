package offer.chain_table;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Offer052 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode tempA = headA;
    ListNode tempB = headB;
    while (tempA != tempB) {
      tempA = tempA == null ? headB : tempA.next;
      tempB = tempB == null ? headA : tempB.next;
    }
    return tempA;
  }

  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    Stack<ListNode> stackA = new Stack<>();
    Stack<ListNode> stackB = new Stack<>();
    ListNode nodeA = headA;
    ListNode nodeB = headB;

    while (nodeA != null) {
      stackA.push(nodeA);
      nodeA = nodeA.next;
    }

    while (nodeB != null) {
      stackB.push(nodeB);
      nodeB = nodeB.next;
    }

    ListNode lastNode = null;
    while (!stackA.isEmpty() && !stackB.isEmpty()) {
      ListNode listNodeA = stackA.pop();
      ListNode listNodeB = stackB.pop();
      if (listNodeA != listNodeB) {
        return lastNode;
      } else {
        lastNode = listNodeA;
      }
    }
    return lastNode;
  }

  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    Set<ListNode> set = new HashSet<>();
    ListNode nodeA = headA;
    while (nodeA != null) {
      set.add(nodeA);
      nodeA = nodeA.next;
    }

    ListNode nodeB = headB;
    while (nodeB != null) {
      if (!set.add(nodeB)) {
        return nodeB;
      }
      nodeB = nodeB.next;
    }
    return null;
  }
}
