/**
 * @author shijiayao
 * @date 2020/10/14 16:22
 */
public class LeetCode9 {

  public static void main(String[] args) {
    LeetCode9 leetCode9 = new LeetCode9();
    System.out.println(leetCode9.isPalindrome(1234));
  }

  public boolean isPalindrome(int x) {
    String reversedStr = (new StringBuilder(x + "")).reverse().toString();
    System.out.println(reversedStr);
    return (x + "").equals(reversedStr);
  }

  public boolean isPalindrome1(int x) {
    //边界判断
    if (x < 0) {
      return false;
    }
    int div = 1;
    //
    while (x / div >= 10) {
      div *= 10;
    }
    while (x > 0) {
      int left = x / div;
      int right = x % 10;
      if (left != right) {
        return false;
      }
      x = (x % div) / 10;
      div /= 100;
    }
    return true;
  }

  public boolean isPalindrome2(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }
    return x == revertedNumber || x == revertedNumber / 10;
  }
}
