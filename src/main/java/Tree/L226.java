package Tree;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * @author yaosen.pys
 * @date 2021/06/02
 */
public class L226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    public static void main(String[] args) {

    }
}
