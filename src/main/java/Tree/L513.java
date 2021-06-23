package Tree;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/21
 */
public class L513 {
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        TreeNode left = null;
        while (!queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }

                if (i == 0) {
                    left = temp;
                }
            }
        }
        return left.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode temp1 = new TreeNode(2);
        TreeNode temp2 = new TreeNode(3);
        TreeNode temp3 = new TreeNode(4);
        TreeNode temp4 = new TreeNode(5);
        TreeNode temp5 = new TreeNode(6);
        TreeNode temp6 = new TreeNode(7);
        root.left = temp1;
        root.right = temp2;
        temp1.left = temp3;
        temp2.left = temp4;
        temp2.right = temp5;
        temp4.left = temp6;

        System.out.println(findBottomLeftValue(root));
    }
}
