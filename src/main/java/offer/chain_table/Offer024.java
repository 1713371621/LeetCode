package offer.chain_table;

public class Offer024 {
  public ListNode reverseList(ListNode head) {
    return recur(head, null);
  }

  private ListNode recur(ListNode cur, ListNode pre) {
    if (cur == null) return pre;
    ListNode res = recur(cur.next, cur);
    cur.next = pre;
    return res;
  }


  public ListNode reverseList1(ListNode head) {
    ListNode cur = head, pre = null;
    while (cur != null) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
    return pre;
  }
}
