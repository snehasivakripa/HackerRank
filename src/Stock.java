import java.util.Scanner;

/*
* You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*
* */
public class Stock {

    // Below code uses two loop and give O(n^2) time
    public int maxProfit(int[] prices) {
        int max = 0;
        int j = 0;
        for (int i = 0; i < prices.length; i++) {
            j = i + 1;
            while (j < prices.length) {
                if (prices[i] < prices[j]) {
                    int profit = prices[j] - prices[i];
                    if (max < profit) {
                        max = profit;
                    }
                }
                j = j + 1;

            }
        }
        return max;
    }

    //Below code uses one loop and depends on length of array
    // Time complexity O(n)
    public int maxProfitBetter(int[] prices) {
        int small_value=Integer.MAX_VALUE;
        int highest_profit=0;
        int difference=0;
        for (int i = 0; i < prices.length; i++) {
                if(prices[i]<small_value){ small_value=prices[i];}
                difference=prices[i]-small_value;
                if(highest_profit<difference) highest_profit=difference;
        }
        return highest_profit;
    }

    public static void main(String args[]) {
        Stock s = new Stock();
        int prices[] = {7,3,5,1,6,4};
        System.out.print(s.maxProfitBetter(prices));
    }
}
