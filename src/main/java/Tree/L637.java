package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 *
 * @author yaosen.pys
 * @date 2021/06/16
 */
public class L637 {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageValue = new ArrayList<>();
        if (root == null) {
            return averageValue;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Double sumLevel = 0.0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                sumLevel += temp.val;

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            averageValue.add(sumLevel / levelSize);
        }

        return averageValue;
    }

    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15  7
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode temp1 = new TreeNode(9);
        TreeNode temp2 = new TreeNode(20);
        TreeNode temp3 = new TreeNode(15);
        TreeNode temp4 = new TreeNode(7);

        root.left = temp1;
        root.right = temp2;
        temp1.left = temp3;
        temp2.right = temp4;

        List<Double> result = averageOfLevels(root);

        result.forEach(p -> System.out.println(p));
    }
}
