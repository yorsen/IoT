package TwoPointer;

/**
 * @author yaosen.pys
 * @date 2021/05/10
 */
public class L633 {

    /**
     * a^2 + b^2 = c
     * @param c
     * @return
     */
    public static  boolean judgeSquareSum(int c) {
        if(c<0) {
            return false;
        }

        int start = 0;
        int end = 46340;

        while(start <= end) {
            if(start * start + end * end < 0) {
                end--;
            } else if (start * start + end * end > c) {
                end--;
            } else if(start * start + end * end < c) {
                start++;
            } else if(start * start + end * end == c) {
                return true;
            }
        }

        return false;
    }


    public static  void main(String[] args) {
        int value = 1;
        System.out.println(judgeSquareSum(value));
    }
}
