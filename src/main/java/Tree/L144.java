package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/23
 */
public class L144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }


        Stack<TreeNode> stack = new Stack();
        TreeNode pre = root;

        while (pre != null || !stack.isEmpty()) {
            if (pre != null) {
                result.add(pre.val);
                stack.push(pre);
                pre = pre.left;
            } else {
                TreeNode temp = stack.pop();
                pre = temp.right;
            }
        }

        return result;
    }
}
