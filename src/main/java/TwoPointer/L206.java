package TwoPointer;

import java.util.List;

import javax.swing.*;

/**
 * @author yaosen.pys
 * @date 2021/05/16
 */
public class L206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode temp = reverseList(head.next);
        next.next = head;
        head.next = null;

        return temp;
    }

    //public static ListNode reverseList(ListNode head) {
    //    if (head == null) {
    //        return head;
    //    }
    //
    //    ListNode result = null;
    //    while (head != null) {
    //        ListNode temp = head.next;
    //        head.next = result;
    //        result = head;
    //        head = temp;
    //    }
    //
    //    return result;
    //}

    public static void main(String[] args) {
        //1,2,3,4,5
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode result = reverseList(one);

        System.out.println("ok");
    }
}
