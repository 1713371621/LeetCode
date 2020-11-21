package task;

import java.util.*;

public class DemoTask1 {
  public int solution(int[] A) {
    Arrays.sort(A);
    if (A[A.length - 1] <= 0) {
      return 1;
    }
    Set<Integer> set = new HashSet<>();
    for (int j : A) {
      set.add(j);
    }

    if (A[0] > 1) {
      return 1;
    }

    for (int i = A[0]; i<= A[A.length - 1]; i++) {
      if (set.add(i)) {
        return i;
      }
    }
    return A[A.length - 1] + 1;
  }
}
