package TwoPointer;

/**
 * @author yaosen.pys
 * @date 2021/05/15
 */
public class L88 {
    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //输出：[1,2,2,3,5,6]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];

        int mIndex = 0;
        int nIndex = 0;

        for (int i = 0; i < (m + n); i++) {
            if (mIndex < m && nIndex < n && nums1[mIndex] < nums2[nIndex]) {
                result[i] = nums1[mIndex++];
            } else if (mIndex < m && nIndex < n && nums1[mIndex] >= nums2[nIndex]) {
                result[i] = nums2[nIndex++];
            } else {
                if (mIndex < m) {
                    result[i] = nums1[mIndex++];
                } else if (nIndex < n) {
                    result[i] = nums2[nIndex++];
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }

        System.out.println("ok");
    }

    public static void main(String[] args) {
        //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //输出：[1,2,2,3,5,6]
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        nums1[3] = 0;
        nums1[4] = 0;
        nums1[5] = 0;

        int[] nums2 = new int[3];
        nums2[0] = 2;
        nums2[1] = 5;
        nums2[2] = 6;
        merge(nums1, 3, nums2, 3);

        //nums1 = [1], m = 1, nums2 = [], n = 0
        //int[] nums1 = new int[1];
        //nums1[0] = 1;
        //
        //int[] nums2 = new int[0];
        //
        //merge(nums1, 1, nums2, 0);
    }
}
