package Tree;

import java.util.Stack;

import javax.swing.text.TabableView;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * @author yaosen.pys
 * @date 2021/06/27
 */
public class L230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;

        int value = 0;
        while (pre != null || !stack.isEmpty()) {
            if (pre != null) {
                stack.push(pre);
                pre = pre.left;
            } else {
                TreeNode temp = stack.pop();
                value++;
                if (value == k) {
                    return temp.val;
                }
                pre = temp.right;
            }
        }

        return 0;
    }
}
