import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shijiayao
 * @date 2020/10/22 15:32
 */
public class LeetCode15 {

  public static void main(String[] args) {
    LeetCode15 leetCode15 = new LeetCode15();
    for (List<Integer> integers : leetCode15.threeSum(new int[]{-1, 0, 1, 2, -1, -4})) {
      System.out.println(Arrays.toString(integers.toArray()));
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {

    //排序
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();

    int left = 0;
    int right = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) {
        break;
      }

      // 去重
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      left = i + 1;
      right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        } else if (sum < 0) {
          left++;
        } else {
          right--;
        }
      }

    }
    return lists;
  }

  public List<List<Integer>> threeSum1(int[] nums) {

    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> integers = new ArrayList<>();
            integers.add(nums[i]);
            integers.add(nums[j]);
            integers.add(nums[k]);
            if (!lists.contains(integers)) {
              lists.add(integers);
            }
          }
        }
      }
    }
    return lists;
  }
}
