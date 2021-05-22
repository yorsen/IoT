package TwoPointer;

/**
 * @author yaosen.pys
 * @date 2021/05/10
 */
public class L167 {

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                --end;
            } else if (numbers[start] + numbers[end] < target) {
                ++start;
            } else if (numbers[start] + numbers[end] == target) {
                break;
            }
        }

        int[] result = new int[2];
        result[0] = start + 1;
        result[1] = end + 1;

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = new int[3];

        numbers[0] = 2;
        numbers[1] = 3;
        numbers[2] = 4;

        int target = 6;

        int[] result = twoSum(numbers, target);

        System.out.println(result[0]);

        System.out.println(result[1]);
    }
}
