package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author yaosen.pys
 * @date 2021/05/24
 */
public class L347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int value : nums) {
            values.put(value, values.getOrDefault(value, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer key : values.keySet()) {
            int value = values.get(key);
            List<Integer> temp = null;
            if (buckets[value] == null) {
                temp = new ArrayList<>();
            } else {
                temp = buckets[value];
            }
            temp.add(key);
            buckets[value] = temp;
        }

        int[] result = new int[k];
        int i = 0;
        for (int temp = buckets.length - 1; temp > 0; temp--) {
            if (buckets[temp] == null) {
                continue;
            }
            List<Integer> value = buckets[temp];
            int j = 0;
            while (i < k && j < value.size()) {
                result[i++] = value.get(j++);
            }

            if (i >= k) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] value = new int[8];
        value[0] = 1;
        value[1] = 1;
        value[2] = 1;
        value[3] = 2;
        value[4] = 2;
        value[5] = 2;
        value[6] = 3;
        value[7] = 3;

        int[] result = topKFrequent(value, 2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
