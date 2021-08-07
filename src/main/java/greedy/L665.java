package greedy;

/**
 * @author yaosen.pys
 * @date 2021/07/21
 */
public class L665 {
    public static boolean checkPossibility(int[] nums) {
        if (null == nums || nums.length < 2) {
            return true;
        }
        int largeNumber = 0;
        int continuousSmall = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                largeNumber++;
                nums[i] = nums[i + 1];
                if (i > 0 && nums[i - 1] > nums[i]) {
                    continuousSmall++;
                }
            }

            if (largeNumber > 1 || continuousSmall > 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 2, 3, 4, 5};
        //System.out.println(checkPossibility(nums));

        //int[] nums = {3, 4, 2, 3};  false
        //System.out.println(checkPossibility(nums));


        //int[] nums = {4, 2, 1, 4, 5}; false
        //System.out.println(checkPossibility(nums));


        //int[] nums = {4, 2, 3, 4, 5};
        //System.out.println(checkPossibility(nums));


        int[] nums = {5,7,1,8};
        System.out.println(checkPossibility(nums));
    }
}
