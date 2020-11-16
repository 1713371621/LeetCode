package offer.tree;

public class Offer033 {

  public boolean verifyPostorder(int[] postorder) {
    return recur(postorder, 0, postorder.length - 1);
  }

  boolean recur(int[] postorder, int start, int end) {
    if (start >= end) return true;
    int index = start;
    while (postorder[index] < postorder[end]) index++;
    int leftTreePoint = index;
    while (postorder[index] > postorder[end]) index++;
    return index == end && recur(postorder, start, leftTreePoint - 1) && recur(postorder, leftTreePoint, end - 1);
  }
}
