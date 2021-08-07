package greedy;

/**
 * @author yaosen.pys
 * @date 2021/07/19
 */
public class L392 {
    public static boolean isSubsequence(String s, String t) {
        if(s == null || t == null) {
            return false;
        }


        char[] schars = s.toCharArray();
        int index = -1;
        for (char temp : schars) {
            index = t.indexOf(temp, index + 1);
            if (index == -1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "";
        String t = "abcd";


        System.out.println(isSubsequence(s, t));
    }
}
