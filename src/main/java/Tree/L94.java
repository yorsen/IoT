package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/23
 */
public class L94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = root;
        while (pre != null || !stack.isEmpty()) {
            if (pre != null) {
                stack.push(pre);
                pre = pre.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                pre = temp.right;
            }
        }

        return result;
    }
}
