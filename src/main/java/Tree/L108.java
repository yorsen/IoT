package Tree;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/27
 */
public class L108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length-1);
    }

    private TreeNode create(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }

        int mid = begin + end / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = create(nums, begin, mid - 1);
        root.right = create(nums, mid + 1, end);

        return root;
    }
}
