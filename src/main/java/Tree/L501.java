package Tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/07/05
 */
public class L501 {
    static int max = 0;

    public static int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        findPreOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (int num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private static void findPreOrder(TreeNode root, List<Integer> maxCntNums) {
        if (root == null) {
            return;
        }

        int rootTime = equal(root.val, root.left) + equal(root.val, root.right) + 1;

        if (rootTime > max) {
            maxCntNums.clear();
            max = rootTime;
            maxCntNums.add(root.val);
        } else if (rootTime == max) {
            maxCntNums.add(root.val);
        }

        findPreOrder(root.left, maxCntNums);
        findPreOrder(root.right, maxCntNums);
    }

    private static int equal(int value, TreeNode root) {
        int time = 0;
        if (root == null) {
            return 0;
        }

        if (root.val == value) {
            time++;
        }

        return time + equal(value, root.left) + equal(value, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode temp1 = new TreeNode(2);
        TreeNode temp2 = new TreeNode(0);
        TreeNode temp3 = new TreeNode(4);
        TreeNode temp4 = new TreeNode(2);
        TreeNode temp5 = new TreeNode(6);
        TreeNode temp6 = new TreeNode(8);
        TreeNode temp7 = new TreeNode(7);
        TreeNode temp8 = new TreeNode(9);

        root.left = temp1;
        temp1.left = temp2;
        temp1.right = temp3;
        temp3.left = temp4;
        temp3.right = temp5;

        root.right = temp6;
        temp6.left = temp7;
        temp6.right = temp8;

        int[] result = findMode(root);

        for (int value : result) {
            System.out.println(value);
        }
    }
}
