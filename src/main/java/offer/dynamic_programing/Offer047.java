package offer.dynamic_programing;

import java.util.Arrays;

public class Offer047 {
  public static void main(String[] args) {
    Offer047 offer047 = new Offer047();
    int[][] ints = {{
      1, 2, 5
    }, {
      3, 2, 1
    }};
    System.out.println(offer047.maxValue(ints));
  }

  public int maxValue(int[][] grid) {
    int[] gridX = grid[0];
    int x = gridX.length;
    int y = grid.length;

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (j - 1 >= 0 && i - 1 >= 0) {
          grid[j][i] = grid[j][i] + Math.max(grid[j][i - 1], grid[j - 1][i]);
        } else if (j - 1 >= 0) {
          grid[j][i] = grid[j][i] + Math.max(0, grid[j - 1][i]);
        } else if (i - 1 >= 0) {
          System.out.println("i = " + i + ", j = " + j);
          grid[j][i] = grid[j][i] + Math.max(grid[j][i - 1], 0);
        }
      }
    }
    for (int[] i : grid) {
      System.out.println(Arrays.toString(i));
    }
    return grid[y - 1][x - 1];
  }
}
