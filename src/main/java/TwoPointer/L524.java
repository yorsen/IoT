package TwoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaosen.pys
 * @date 2021/05/16
 */
public class L524 {
    public static String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        Boolean begin = true;
        for (String item : dictionary) {
            if (item.length() < result.length()) {
                continue;
            }

            if (isSubStr(s, item)) {
                if(item.length() > result.length()) {
                    result = item;
                } else if (item.compareTo(result) < 0) {
                    result = item;
                }
            }
        }

        return result;
    }

    private static boolean isSubStr(String s, String target) {
        int i = 0, j = 0;

        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }

            i++;
        }

        if (j == target.length()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "abce";
        List<String> values = new ArrayList<String>();
        //values.add("ale");
        //values.add("apple");
        //values.add("monkey");
        //values.add("plea");


        values.add("abe");
        values.add("abc");

        System.out.println(findLongestWord(s, values));

    }
}
