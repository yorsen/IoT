package greedy;

/**
 * @author yaosen.pys
 * @date 2021/07/17
 */
public class L122 {
    //[7,1,5,3,6,4]
    public static  int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }

        int buyPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
                continue;
            }

            if ((i + 1) < prices.length && prices[i] > prices[i + 1]) {
                profit += (prices[i] - buyPrice);
                buyPrice = prices[i];
                continue;
            }

            if ((i + 1) == prices.length && buyPrice < prices[i]) {
                profit += (prices[i] - buyPrice);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        //[7,1,2,3,4,5]
        int[] prices = new int[6];
        prices[0] = 7;
        prices[1] = 1;
        prices[2] = 2;
        prices[3] = 3;
        prices[4] = 4;
        prices[5] = 5;
        System.out.println(maxProfit(prices));
    }
}
