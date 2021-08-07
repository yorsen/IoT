package greedy;

/**
 * @author yaosen.pys
 * @date 2021/07/19
 */
public class L605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int flowers = 0;
        for (int i = 0; i < len && flowers < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                flowers++;
                flowerbed[i] = 1;
            }
        }
        return flowers >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[1];
        flowerbed[0] = 0;

        System.out.println(canPlaceFlowers(flowerbed, 1));
    }
}
