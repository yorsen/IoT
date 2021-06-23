package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/23
 */
public class L145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;
        Set<TreeNode> set = new HashSet<>();
        while (pre != null || !stack.isEmpty()) {
            if (pre != null) {
                stack.push(pre);
                pre = pre.left;
            } else if (pre == null) {
                TreeNode temp = stack.pop();
                if (temp.left == null && temp.right == null) {
                    result.add(temp.val);
                    set.add(temp);
                    pre = null;
                    continue;
                }

                if (temp.right != null && !set.contains(temp.right)) {
                    stack.push(temp);
                    pre = temp.right;
                    continue;
                }

                if (temp.right != null && set.contains(temp.right)) {
                    result.add(temp.val);
                    set.add(temp);
                    pre = null;
                    continue;
                }
            }
        }

        return result;
    }

}
