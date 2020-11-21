package task;

public class Task1 {

  public static void main(String[] args) {
    Task1 task1 = new Task1();
//    int[] ints = {14,21,16,35,22};
    int[] ints = {4,2,5,8,7,3,7};
    System.out.println(task1.solution(ints));
  }
  public int solution(int[] A) {
    if (A.length <= 1) {
      return 0;
    }

    int nums1 = 0;
    for (int i = 0; i <= (A.length - 1) / 2; i++) {
      int sum;
      if (2 * i == A.length - 1) {
        sum = A[A.length - 1] + A[0];
      } else {
        sum = A[2 * i] + A[2 * i + 1];
      }
      if (sum % 2 == 0) {
        nums1++;
      }
    }

    int nums2 = 0;
    for (int i = 0; i <= (A.length - 2) / 2; i++) {
      int sum;
      if (2 * i + 1 == A.length - 1) {
        sum = A[A.length - 1] + A[0];
      } else {
        sum = A[2 * i + 1] + A[2 * i + 2];
      }
      if (sum % 2 == 0) {
        nums2++;
      }
    }
    return Math.max(nums1, nums2);
  }
}
