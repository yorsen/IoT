package common;

import List.L19;

/**
 * @author yaosen.pys
 * @date 2021/05/18
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("ok");
        }

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
