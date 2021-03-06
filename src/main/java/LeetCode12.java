import java.util.HashMap;
import java.util.Map;

/**
 * @author shijiayao
 * @date 2020/10/14 16:58
 */
public class LeetCode12 {

  public static void main(String[] args) {
    LeetCode12 leetCode12 = new LeetCode12();
    System.out.println(leetCode12.intToRoman(3000));
  }

  public String intToRoman(int num) {
    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder stringBuilder = new StringBuilder();
    int index = 0;
    while (index < 13) {
      // 特别注意：这里是等号
      while (num >= nums[index]) {
        stringBuilder.append(romans[index]);
        num -= nums[index];
      }
      index++;
    }
    return stringBuilder.toString();
  }

  public String intToRoman1(int num) {
    ///char* c[4][10] = {
    //            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
    //            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
    //            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
    //            {"","M","MM","MMM"}
    //        };

    String[][] strings = new String[][]{
        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
        {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
        {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
        {"", "M", "MM", "MMM"}
    };

    return strings[3][num / 1000]
        + strings[2][num / 100 % 10]
        + strings[1][num / 10 % 10]
        + strings[0][num % 10];
  }

}