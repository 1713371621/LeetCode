import java.util.Arrays;

/**
 * @author shijiayao
 * @date 2020/10/22 16:03
 */
public class MergeSort {

  private static int[] arr = {100, 20, 15, 30, 5, 75, 40};

  public static void main(String[] args) {

//    System.out.println("before sort: ints = " + Arrays.toString(arr));
    int[] ints = new int[]{-1, 1, 3, 2, 6, 2, -12, 34, 5};
    MergeSort mergeSort = new MergeSort(ints);
//    mergeSort(0, arr.length - 1);
    System.out.println("after sort: ints = " + Arrays.toString(ints));
  }

  public MergeSort() {

  }

  public MergeSort(int[] ints) {
    arr = ints;
    mergeSort(0, arr.length - 1);
  }

  public void mergeSort(int start, int end) {
    int mid = (start + end) / 2;
    System.out.println("start: " + start + ", mid: " + mid + ", end: " + end);
    if (start < end) {
      mergeSort(start, mid);
      mergeSort(mid + 1, end);
      merge(start, mid, end);
    }
  }

  private static void merge(int start, int mid, int end) {
    int[] tempArray = new int[arr.length];
    int tempArrayIndex = start;
    System.out.println("before merge: start: " + start + ", mid: " + mid + ", end: " + end);
    printArray(arr, start, end);

    int startIndex = start;
    int midIndex = mid + 1;

    while (startIndex <= mid && midIndex <= end) {
      System.out
          .println("arr[startIndex] = " + arr[startIndex] + ", arr[midIndex] = " + arr[midIndex]);

      if (arr[startIndex] < arr[midIndex]) {
        tempArray[tempArrayIndex++] = arr[startIndex++];
      } else {
        tempArray[tempArrayIndex++] = arr[midIndex++];
      }
    }

    System.out.println(Arrays.toString(tempArray));

    System.out.println(
        "startIndex = " + startIndex + ", midIndex = " + midIndex + ", tempArrayIndex = "
            + tempArrayIndex);

    while (startIndex <= mid) {
      tempArray[tempArrayIndex++] = arr[startIndex++];
    }
    while (midIndex <= end) {
      tempArray[tempArrayIndex++] = arr[midIndex++];
    }

    System.out.println(Arrays.toString(tempArray));

    for (int i = start; i <= end; i++) {
      arr[i] = tempArray[i];
    }

    System.out.println("after merge:");
    printArray(tempArray, start, end);
    System.out.println();
  }

  public static void printArray(int[] arrays, int start, int end) {
    for (int i = start; i <= end; i++) {
      System.out.print(arrays[i] + " ");
    }
    System.out.println();
  }
}
