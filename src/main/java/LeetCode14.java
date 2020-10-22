/**
 * @author shijiayao
 * @date 2020/10/16 15:43
 */
public class LeetCode14 {

  public static void main(String[] args) {
    System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"", ""}));
  }

  public String longestCommonPrefix(String[] strs) {

    if (strs.length == 0) {
      return "";
    }
    String minStr = strs[0];
    for (String str : strs) {
      if (str.length() <= minStr.length()) {
        minStr = str;
      }
    }

    int minStrLen = minStr.length();

    StringBuilder commonPrefix = new StringBuilder();
    for (int i = 0; i < minStrLen; i++) {
      boolean notSameCommonPrefix = false;
      char c = minStr.charAt(i);
      for (String s : strs) {
        if (c != s.charAt(i)) {
          notSameCommonPrefix = true;
          break;
        }
      }
      if (!notSameCommonPrefix) {
        commonPrefix.append(c);
      } else {
        return commonPrefix.toString();
      }
    }
    return commonPrefix.toString();
  }
}
