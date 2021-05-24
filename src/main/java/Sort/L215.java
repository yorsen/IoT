package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * findKthLargest
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * @author yaosen.pys
 * @date 2021/05/22
 */
public class L215 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.<Integer>reverseOrder());

        for (Integer value : nums) {
            queue.add(value);
        }

        int value = 0;
        while (k > 0) {
            value = queue.poll();
            k--;
        }

        return value;
    }

    public static void main(String[] args) {
        int[] value = new int[8];
        value[0] = 47;
        value[1] = 29;
        value[2] = 71;
        value[3] = 99;
        value[4] = 78;
        value[5] = 19;
        value[6] = 24;
        value[7] = 47;
        System.out.println(findKthLargest(value, 8));
    }
}
