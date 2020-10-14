/**
 * @author shijiayao
 * @date 2020/10/14 16:36
 */
public class LeetCode11 {

  public static void main(String[] args) {
    System.out.println(new LeetCode11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  public int maxArea(int[] height) {
    int i = 0, j = height.length - 1, res = 0;

    while (i < j) {
      if (height[i] < height[j]) {
        int area = (j - i) * height[i];
        res = Math.max(res, area);
        i++;
      } else {
        int area = (j - 1) * height[j];
        res = Math.max(res, area);
        j--;
      }
    }
    return res;
  }

  public int maxArea1(int[] height) {

    int max = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int minHeight = Math.min(height[i], height[j]);
        int length = j - i;
        int area = length * minHeight;
        max = Math.max(max, area);
      }
    }
    return max;
  }
}
