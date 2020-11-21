package task;

import java.util.HashSet;
import java.util.Set;

public class Task3 {
  public static void main(String[] args) {
    Task3 task3 = new Task3();
//    int[] ints = {7,3,7,3,1,3,4,1};
    int[] ints = {2,1,1,3,2,1,1,3};
    System.out.println(task3.solution(ints));
  }
  public int solution(int[] A) {
    Set<Integer> area = new HashSet<>();
    for (int i : A) {
      area.add(i);
    }

    int start = 0;
    int end = 0;
    while (!area.isEmpty()) {
      area.remove(A[end]);
      end++;
      if (A[start] == A[end]) {
        start++;
      }
    }
    return end - start;
  }
}
