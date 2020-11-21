package offer.dynamic_programing;

public class Offer063 {
  public int maxProfit(int[] prices) {
    int cost = Integer.MAX_VALUE, profit = 0;
    for(int price : prices) {
      cost = Math.min(cost, price);
      profit = Math.max(profit, price - cost);
    }
    return profit;
  }

  public int maxProfit1(int[] prices) {
    int max = 0;
    int start = 0;
    int end = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int value = -prices[i] + prices[j];
        if (value > max) {
          start = i;
          end = j;
          max = value;
        }
      }
    }
    return max;
  }
}
