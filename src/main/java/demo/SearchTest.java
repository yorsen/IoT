package demo;

import common.TreeNode;
import demo.Printer;

/**
 * @author yaosen.pys
 * @date 2021/06/22
 */
public class SearchTest {
    /**
     * 1
     * /  \
     * 2    3
     * / \   \
     * 4  5   6
     *
     * @param args
     */

    public static void main(String[] args) {
        //TreeNode temp1 = new TreeNode(1);
        //TreeNode temp2 = new TreeNode(2);
        //TreeNode temp3 = new TreeNode(3);
        //TreeNode temp4 = new TreeNode(4);
        //TreeNode temp5 = new TreeNode(5);
        //TreeNode temp6 = new TreeNode(6);
        //
        //temp1.left = temp2;
        //temp1.right = temp3;
        //temp2.left = temp4;
        //temp2.right = temp5;
        //temp3.right = temp6;
        // 1,2,4,5,3,6
        // TreeNode.preOrder(temp1);

        // 4,2,5,1,3,6
        //TreeNode.middleOrder(temp1);

        // 4,5,2,6,3,1
        //TreeNode.afterOrder(temp1);

        //1,2,4,5,3,6
        //Printer.preOrder(temp1);

        //4,2,5,1,3,6
        //Printer.middleOrder(temp1);

        //Printer.postOrder(temp1);

        TreeNode temp1 = new TreeNode(1);
        TreeNode temp2 = new TreeNode(2);
        TreeNode temp3 = new TreeNode(3);

        temp1.right = temp2;
        temp2.left = temp3;

        Long startTime = System.currentTimeMillis();
        Printer.postOrder(temp1);

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
