package demo;

import java.util.Objects;
import java.util.Stack;

import common.TreeNode;

/**
 * @author yaosen.pys
 * @date 2021/06/24
 */
public class BST {
    public static boolean searchTypeRecursion(TreeNode root, int value) {
        if (root == null) {
            return false;
        } else if (root.val > value) {
            return searchTypeRecursion(root.left, value);
        } else if (root.val < value) {
            return searchTypeRecursion(root.right, value);
        } else {
            return true;
        }
    }

    public static boolean searchType(TreeNode root, int value) {
        TreeNode pre = root;

        while (pre != null) {
            if (pre.val == value) {
                return true;
            } else if (pre.val < value) {
                pre = pre.right;
            } else {
                pre = pre.left;
            }
        }
        return false;
    }

    public static TreeNode insertRecursion(TreeNode root, int value) {
        if (root == null) {
            TreeNode node = new TreeNode(value);
            return node;
        } else if (root.val > value) {
            root.left = insertRecursion(root.left, value);
        } else if (root.val < value) {
            root.right = insertRecursion(root.right, value);
        }

        return root;
    }

    public static TreeNode insert(TreeNode root, int value) {
        TreeNode pre = null;
        TreeNode next = root;
        while (next != null) {
            pre = next;
            if (next.val == value) {
                return root;
            } else if (next.val > value) {
                next = next.left;
            } else {
                next = next.right;
            }
        }

        if (pre == null) {
            return new TreeNode(value);
        } else if (pre.val > value) {
            pre.left = new TreeNode(value);
        } else {
            pre.right = new TreeNode(value);
        }

        return root;
    }

    public static TreeNode deleteRecursion(TreeNode root, int value) {
        if (root == null) {
            return root;
        }

        if (root.val < value) {
            root.right = deleteRecursion(root.right, value);
        } else if (root.val > value) {
            root.left = deleteRecursion(root.left, value);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode rightLeftChild = findLeft(root.left);
            root.val = rightLeftChild.val;
            deleteRecursion(root.right, rightLeftChild.val);
            return rightLeftChild;
        }

        return root;
    }

    public static TreeNode delete(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode next = root;
        while (next != null) {
            stack.push(next);
            if (next.val == value) {
                break;
            } else if (root.val > value) {
                next = next.left;
            } else {
                next = next.right;
            }
        }

        if (next == null) {
            //没有找到待删除的节点
            return root;
        }

        stack.pop();
        TreeNode pre = stack.pop();
        if (next.left == null) {
            if (pre.left != null && pre.left.val == next.val) {
                pre.left = next.right;
            } else if (pre.right != null && pre.right.val == next.val) {
                pre.right = next.right;
            }
        } else if (next.right == null) {
            if (pre.left != null && pre.left.val == next.val) {
                pre.left = next.left;
            } else if (pre.right != null && pre.right.val == next.val) {
                pre.right = next.left;
            }
        } else {
            TreeNode temp = findAndRemoveLeft(next);
            next.val = temp.val;
        }

        return root;
    }

    private static TreeNode findLeft(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    private static TreeNode findAndRemoveLeft(TreeNode root) {
        TreeNode pre = root;
        TreeNode next = root;
        while (next.left != null) {
            pre = next;
            next = next.left;
        }

        pre.left = null;

        return next;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        for (int i = 0; i < 15; i++) {
            root = insert(root, i);
        }

        Printer.inOrder(root);

        System.out.println(searchType(root, 15));
        System.out.println(searchType(root, 14));
        System.out.println(searchType(root, 12));


        delete(root, 9);

        Printer.inOrder(root);
        System.out.println(searchType(root, 9));
    }
}
