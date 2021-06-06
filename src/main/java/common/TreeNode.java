package common;

/**
 * @author yaosen.pys
 * @date 2021/05/31
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);

        print(root.left);
        print(root.right);
    }
}
