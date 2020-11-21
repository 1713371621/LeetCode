package task;

import java.util.*;

public class Task2 {
  public static void main(String[] args) {
    Task2 task2 = new Task2();
    int[] A = {2, 2, 1, 2};
    int[] B = {1, 3, 4, 4};
    System.out.println(task2.solution(5, A, B));
  }

  public int solution(int N, int[] A, int[] B) {
    int M = A.length;

    Set<String> set = new HashSet<>();
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      if (A[i] != B[i]) {
        int[] ints = new int[2];
        ints[0] = A[i];
        ints[1] = B[i];
        String key = Arrays.toString(ints);
        if (set.add(key)) {
          list.add(ints);
        }
      }
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int[] ints : list) {
      int first = ints[0];
      int second = ints[1];
      if (map.containsKey(first)) {
        int value = map.get(first);
        map.put(first, value + 1);
      } else {
        map.put(first, 1);
      }

      if (map.containsKey(second)) {
        int value = map.get(second);
        map.put(second, value + 1);
      } else {
        map.put(second, 1);
      }
    }

    int[] values = new int[map.size()];
    Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
    int index = 0;
    while (iterator.hasNext()) {
      Map.Entry<Integer, Integer> entry = iterator.next();
      int value = entry.getValue();
      values[index] = value;
      index++;
    }

    Arrays.sort(values);
    List<Integer> keys = new ArrayList<>();

    int keysIndex = 0;
    for (int value : values) {
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int mapKey = entry.getKey();
        int mapValue = entry.getValue();
        if (mapValue == value && !keys.contains(mapKey)) {
          keys.add(mapKey);
        }
        keysIndex++;
      }
    }

    int keysSize = keys.size();
    Map<Integer, Integer> keyMap = new HashMap<>();
    for (int i = 0; i < keys.size(); i++) {
      keyMap.put(keys.get(keysSize - i - 1), N - i);
    }

    int sum = 0;

    for (int[] ints1 : list) {
      int first = ints1[0];
      int second = ints1[1];
      sum += keyMap.get(first) + keyMap.get(second);
    }
    return sum;
  }
}
