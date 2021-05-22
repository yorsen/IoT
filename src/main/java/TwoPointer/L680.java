package TwoPointer;

/**
 * @author yaosen.pys
 * @date 2021/05/12
 */
public class L680 {
    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return valid(s, start, end - 1) || valid(s, start + 1, end);
            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean valid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //abca     true
        //aba      true
        //abccba   true
        //abcca    true
        //eeccccbebaeeabebccceea false
        String value
            = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

        System.out.println(validPalindrome(value));
    }
}
