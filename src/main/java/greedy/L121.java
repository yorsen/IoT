package greedy;

/**
 * @author yaosen.pys
 * @date 2021/07/17
 */
public class L121 {
    //[7,1,5,3,6,4]
    public static int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxDiff = 0;
        for (int i = 1; i < prices.length; i++) {
            int value = prices[i] - minPrice;

            if (value > maxDiff) {
                maxDiff = value;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        //[7,1,5,0,10,4]
        int[] prices = new int[6];
        prices[0] = 7;
        prices[1] = 1;
        prices[2] = 5;
        prices[3] = 0;
        prices[4] = 10;
        prices[5] = 4;
        System.out.println(maxProfit(prices));

        //[7,6,4,3,1]
        //int[] prices = new int[5];
        //prices[0] = 7;
        //prices[1] = 6;
        //prices[2] = 4;
        //prices[3] = 3;
        //prices[4] = 1;
        //System.out.println(maxProfit(prices));
    }
}
