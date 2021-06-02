package List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
 *
 * @author yaosen.pys
 * @date 2021/05/27
 */
public class L451 {
    public static String frequencySort(String s) {
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character character : charCountMap.keySet()) {
            List<Character> item = buckets[charCountMap.get(character)];
            if (null == item) {
                item = new ArrayList<>();
            }
            item.add(character);
            buckets[charCountMap.get(character)] = item;
        }

        char[] result = new char[s.length()];
        int i = 0;
        int j = buckets.length;
        while ((j--) > 0) {
            List<Character> values = buckets[j];
            if (values != null) {
                int index = 0;
                while (index < values.size()) {
                    char temp = values.get(index++);
                    for (int frequency = 0; frequency < j; frequency++) {
                        result[i++] = temp;
                    }
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(frequencySort(s));
    }
}
