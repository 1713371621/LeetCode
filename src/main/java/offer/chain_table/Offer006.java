package offer.chain_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Offer006 {

  public static void main(String[] args) {
    ListNode listNode3 = new ListNode(2);
    ListNode listNode2 = new ListNode(3);
    ListNode listNode = new ListNode(1);
    listNode2.next = listNode3;
    listNode.next = listNode2;

    Offer006 offer006 = new Offer006();
    System.out.print(Arrays.toString(offer006.reversePrint(listNode)));
  }

  ArrayList<Integer> tmp = new ArrayList<>();

  public int[] reversePrint(ListNode head) {
    recur(head);
    int[] res = new int[tmp.size()];
    for (int i = 0; i < res.length; i++)
      res[i] = tmp.get(i);
    return res;
  }

  void recur(ListNode head) {
    if (head == null) return;
    recur(head.next);
    tmp.add(head.val);
  }

  /**
   * 使用Stack
   */
  public int[] reversePrint1(ListNode head) {
    if (head == null) {
      return new int[0];
    }
    Stack<Integer> stack = new Stack<>();
    int index = 0;
    while (head.next != null) {
      stack.push(head.val);
      head = head.next;
      index++;
    }
    stack.push(head.val);
    index++;
    int[] ints = new int[index];
    index = 0;
    while (!stack.empty()) {
      ints[index++] = stack.pop();
    }
    return ints;
  }
}

