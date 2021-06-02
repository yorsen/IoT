package Tree;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/05/31
 */
public class L104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param args
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        System.out.println(maxDepth(root));
    }

}
