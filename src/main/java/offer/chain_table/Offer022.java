package offer.chain_table;

public class Offer022 {
  public ListNode getKthFromEnd(ListNode head, int k) {
    if (head == null) {
      return head;
    }
    int length = 0;
    ListNode listNode = head;
    while (listNode.next != null) {
      listNode = listNode.next;
      length++;
    }

    int index = length - k;

    for (int i = 0; i < index + 1; i++) {
      head = head.next;
    }
    return head;
  }

  public ListNode getKthFromEnd1(ListNode head, int k) {
    ListNode former = head, latter = head;
    for (int i = 0; i < k; i++)
      former = former.next;
    while (former != null) {
      former = former.next;
      latter = latter.next;
    }
    return latter;
  }
}
