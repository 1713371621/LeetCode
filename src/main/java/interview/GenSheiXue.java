package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenSheiXue {
  // 如 123456789123456789 * 56789
// 已经按照低位到高位转成整数数组
// a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1}
// b = {9, 8, 7, 6, 5}
  int[] multiply(int[] a, int[] b) {
    List<List<Integer>> numLists = new ArrayList<>();
    for (int value : b) {
      List<Integer> lists = new ArrayList<>();
      for (int k : a) {
        lists.add(value * k);
      }
      int lastNum = 0;
      for (int index = 0; index < lists.size(); index++) {
        lists.set(index, lists.get(index) % 10 + lastNum);
        lastNum = lists.get(index) / 10;
      }
      if (lastNum != 0) {
        lists.add(lastNum);
      }
      numLists.add(lists);
    }

    int[] resultList = new int[numLists.get(b.length - 1).size() + b.length];
    Arrays.fill(resultList, -1);
    for (int i = 0; i < numLists.size(); i++) {
      for (int j = 0; j < numLists.get(i).size(); j++) {
        if (resultList[i + j] == -1) {
          resultList[i + j] = numLists.get(i).get(j);
        } else {
          resultList[i + j] += numLists.get(i).get(j);
        }
      }
    }

    int lastNum = 0;
    for (int index = 0; index < resultList.length; index++) {
      resultList[index] = resultList[index] % 10 + lastNum;
      lastNum = resultList[index] / 10;
    }
    if (lastNum != 0) {
      Arrays.copyOf(resultList, resultList.length + 1);
      resultList[resultList.length - 1] = lastNum;
    }
    return resultList;
  }
}
