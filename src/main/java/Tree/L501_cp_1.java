package Tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/07/05
 */
public class L501_cp_1 {
    private static int curCnt = 1;
    private static int maxCnt = 1;
    private static TreeNode preNode = null;

    public static int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (int num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private static void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) { return; }
        inOrder(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) { curCnt++; } else { curCnt = 1; }
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
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
