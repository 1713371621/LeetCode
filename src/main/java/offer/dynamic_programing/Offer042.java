package offer.dynamic_programing;

public class Offer042 {

  public static void main(String[] args) {
    int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
  }

  public int maxSubArray(int[] nums) {
    int res = nums[0];
    for(int i = 1; i < nums.length; i++) {
      nums[i] += Math.max(nums[i - 1], 0);
      res = Math.max(res, nums[i]);
    }
    return res;
  }
}
