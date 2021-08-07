package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaosen.pys
 * @date 2021/08/02
 */
public class L763 {
    public static List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[index(s.charAt(i))] = i;
        }

        List<Integer> partition = new ArrayList<>();

        int first = 0;
        while (first < s.length()) {
            int last = first;
            for (int i = first; i < s.length() && i <= last; i++) {
                if (last < lastIndex[index(s.charAt(i))]) {
                    last = lastIndex[index(s.charAt(i))];
                }
            }
            partition.add(last - first + 1);
            first = last + 1;
        }

        return partition;
    }

    private static int index(char character) {
        return character - 'a';
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> values = partitionLabels(s);

        for (Integer value : values) {
            System.out.println(value);
        }
    }
}
