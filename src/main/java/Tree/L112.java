package Tree;

import java.util.Objects;

import apple.laf.JRSUIUtils.Tree;
import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum/description/
 *
 * @author yaosen.pys
 * @date 2021/06/06
 */
public class L112 {
    public static  boolean hasPathSum(TreeNode root, int targetSum) {
        int pathSumValue = 0;

        return pathSum(root, pathSumValue, targetSum);
    }

    private  static boolean pathSum(TreeNode root, int pathSumValue, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if ((root.val + pathSumValue) == targetSum) {
                return true;
            }

            return false;
        }

        if (pathSum(root.left, pathSumValue + root.val, targetSum)) {
            return true;
        }

        if (pathSum(root.right, pathSumValue + root.val, targetSum)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        //TreeNode root = new TreeNode(5);
        //
        //TreeNode temp1 = new TreeNode(4);
        //TreeNode temp2 = new TreeNode(8);
        //TreeNode temp3 = new TreeNode(11);
        //TreeNode temp4 = new TreeNode(13);
        //TreeNode temp5 = new TreeNode(4);
        //TreeNode temp6 = new TreeNode(7);
        //TreeNode temp7 = new TreeNode(2);
        //TreeNode temp8 = new TreeNode(7);
        //
        //root.left = temp1;
        //root.right = temp2;
        //
        //temp1.left = temp3;
        //temp3.left = temp6;
        //temp3.right = temp7;
        //
        //temp2.left = temp4;
        //temp2.right = temp5;
        //temp5.right = temp8;
        //
        //System.out.println(hasPathSum(root, 22));



        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(hasPathSum(null, 4));
    }
}


