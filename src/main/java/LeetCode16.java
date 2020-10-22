import java.util.Arrays;

/**
 * @author shijiayao
 * @date 2020/10/22 17:17
 */
public class LeetCode16 {

  public static void main(String[] args) {
    LeetCode16 leetCode16 = new LeetCode16();
    System.out.println(leetCode16.threeSumClosest(new int[]{1, 1, -1, -1, 3}, 3));
  }

  public int threeSumClosest(int[] nums, int target) {
    int closetSum = nums[0] + nums[1] + nums[2];
    int min = Math.abs(closetSum - target);

    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        int distance = Math.abs(sum - target);

        if (distance == 0) {
          return sum;
        } else {
          if (distance < min) {
            min = distance;
            closetSum = sum;
          }
          if (sum - target < 0) {
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            left++;
          } else {
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            right--;
          }
        }
      }
    }
    return closetSum;
  }
}
