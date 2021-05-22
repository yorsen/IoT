package TwoPointer;

/**
 * @author yaosen.pys
 * @date 2021/05/11
 */
public class L365 {
    public static String reverseVowels(String s) {
        if (null == s || s.length() == 1) {
            return s;
        }

        char[] sChar = s.toCharArray();
        int start = 0;
        int end = sChar.length-1;

        while (start <= end) {
            while (start <= end && !validChar(sChar[start])) {
                start++;
            }

            while (start <= end && !validChar(sChar[end])) {
                end--;
            }

            if ( start <= end && validChar(sChar[start]) && validChar(sChar[end])) {
                swap(sChar, start, end);
            }

            start++;
            end--;
        }

        return new String(sChar);
    }

    private static boolean validChar(char s) {
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
            return true;
        }

        if (s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U') {
            return true;
        }

        return false;
    }

    private static void swap(char[] sChar, int start, int end) {
        char temp = sChar[start];
        sChar[start] = sChar[end];
        sChar[end] = temp;
    }

    public static void main(String[] args) {
        String a = ".,";

        System.out.println(reverseVowels(a));
    }
}

