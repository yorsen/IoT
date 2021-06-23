package demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.sun.jmx.remote.internal.ArrayQueue;
import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/22
 */
public class Printer {
    /**
     * 1
     * /  \
     * 2    3
     * / \   \
     * 4  5   6
     * 1,2,4,5,3,6
     */
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode pre = root;

        while (pre != null || !stack.isEmpty()) {
            if (pre != null) {
                System.out.println(pre.val);
                stack.push(pre);
                pre = pre.left;
            } else {
                TreeNode temp = stack.pop();
                pre = temp.right;
            }
        }
    }




    /**
     * 1
     * /  \
     * 2    3
     * / \   \
     * 4  5   6
     * 4,2,5,1,3,6
     */

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = root;
        while (pre != null || !stack.isEmpty()) {
            if (pre != null) {
                stack.push(pre);
                pre = pre.left;
            } else {
                TreeNode temp = stack.pop();
                System.out.println(temp.val);
                pre = temp.right;
            }
        }
    }

    /**
     *   1
     * /  \
     * 2    3
     * / \    \
     * 4  5    6
     * 4,5,2,6,3,1
     *
     *   1
     *    \
     *    2
     *   /
     *   3
     * 3,2,1
     */
    public static void postOrder(TreeNode root) {
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
                    System.out.println(temp.val);
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
                    System.out.println(temp.val);
                    set.add(temp);
                    pre = null;
                    continue;
                }

                if(temp.right == null) {
                    System.out.println(temp.val);
                    set.add(temp);
                    pre = null;
                }
            }
        }
    }
}
