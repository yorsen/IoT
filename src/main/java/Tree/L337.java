package Tree;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/description/
 *
 * @author yaosen.pys
 * @date 2021/06/15
 */
public class L337 {

    private static Map<TreeNode, Integer> rootMaxCache = new HashMap<>();

    public static int rob(TreeNode root) {
        return rootSum(root);
    }

    public static int rootSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (rootMaxCache.containsKey(root)) {
            return rootMaxCache.get(root);
        }

        int sum1 = root.val;
        if (root.left != null) {
            sum1 += (rootSum(root.left.left) + rootSum(root.left.right));
        }
        if (root.right != null) {
            sum1 += (rootSum(root.right.left) + rootSum(root.right.right));
        }

        int sum2 = rootSum(root.left) + rootSum(root.right);
        int result = Math.max(sum1, sum2);
        rootMaxCache.put(root, result);

        return result;
    }

    /**
     * 3
     * /  \
     * 2   5
     * \   \
     * 3   1
     *
     * @param args
     */
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(3);
        //
        //TreeNode temp1 = new TreeNode(2);
        //TreeNode temp2 = new TreeNode(6);
        //TreeNode temp3 = new TreeNode(3);
        //TreeNode temp4 = new TreeNode(1);
        //
        //root.left = temp1;
        //root.right = temp2;
        //
        //temp1.right = temp3;
        //temp2.right = temp4;

        //TreeNode root = new TreeNode(4);
        //TreeNode temp1 = new TreeNode(1);
        //TreeNode temp2 = new TreeNode(2);
        //TreeNode temp3 = new TreeNode(3);
        //
        //root.left = temp1;
        //temp1.left = temp2;
        //temp2.left = temp3;

        TreeNode root = new TreeNode(3);
        TreeNode temp1 = new TreeNode(2);
        TreeNode temp2 = new TreeNode(5);
        TreeNode temp3 = new TreeNode(4);
        TreeNode temp4 = new TreeNode(1);

        root.left = temp1;
        temp1.left = temp2;
        temp1.right = temp3;
        temp3.right = temp4;

        System.out.println(rob(root));
    }
}
