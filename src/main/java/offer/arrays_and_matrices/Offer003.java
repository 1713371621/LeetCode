package offer.arrays_and_matrices;

import java.util.HashSet;
import java.util.Set;

public class Offer003 {
  public static void main(String[] args) {
    Offer003 offer003 = new Offer003();
    int[] nums = {2, 3, 1, 0, 2, 5, 3};
    System.out.print(offer003.findRepeatNumber(nums));
  }

  public int findRepeatNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (!set.add(i)) {
        return i;
      }
    }
    return nums[0];
  }

}
