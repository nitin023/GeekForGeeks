package GeekForGeeks.Amazon;

import java.util.List;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/1
 */
public class BuySellStock {

    //Leetcode
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int costPriceStock = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (costPriceStock < prices[i]) {
                if (maxProfit < prices[i] - costPriceStock) {
                    maxProfit = prices[i] - costPriceStock;
                }
            } else {
                costPriceStock = prices[i];
            }
        }

        return maxProfit;
    }

    //gfg
    private static void calculateStockProfit(List<Integer> stockPriceList, int numElem )
    {
        boolean isProfitExists = false;
        for(int i = 0 ; i+1 < numElem ; i++)
        {
            if(stockPriceList.get(i) < stockPriceList.get(i+1))
            {
                int j = i;
                while (j+1 < numElem &&  stockPriceList.get(j) < stockPriceList.get(j+1))
                {
                    j++;
                }
                isProfitExists = true;
                System.out.print("(" + i + " " + j + ") ");
                i = j;
            }
        }
        if(!isProfitExists)
            System.out.print("No Profit");

        System.out.println();
    }
}
