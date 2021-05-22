package List;

import common.ListNode;

/**
 * @author yaosen.pys
 * @date 2021/05/18
 */
public class L19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        while (n--> 0) {
            second = second.next;
        }

        if (second == null) {
            return first.next;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        //one.next = two;
        //two.next = three;
        //three.next = four;
        //four.next = five;

        ListNode result = removeNthFromEnd(one, 1);

        System.out.println(result);
    }
}
