/**
 * @author shijiayao
 * @date 2020/10/14 18:03
 */
public class LeetCode13 {

  public static void main(String[] args) {
    LeetCode13 leetCode13 = new LeetCode13();
    System.out.println(leetCode13.romanToInt("XXX"));
  }

  public int romanToInt(String s) {

    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    int result = 0;
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    char[] chars = s.toCharArray();
    for (int index = 13; index > 0; index--) {
      if (String.valueOf(chars[0]).equals(romans[index]) ||
          String.valueOf(chars[0] + chars[1]).equals(romans[index])) {
        result += nums[index];
      }
    }
    return 123;
  }
}
