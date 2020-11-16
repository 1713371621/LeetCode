package offer.chain_table;

public class Offer018 {
  public ListNode deleteNode(ListNode head, int val) {
    ListNode listNode = head;
    ListNode lastNode = null;
    while (listNode != null) {
      if (listNode.val == val) {
        if (lastNode != null) {
          lastNode.next = listNode.next;
        } else {
          head = listNode.next;
        }
      }
      lastNode = listNode;
      listNode = listNode.next;
    }
    return head;
  }
}
