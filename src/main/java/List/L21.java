package List;

import common.ListNode;

/**
 * @author yaosen.pys
 * @date 2021/05/17
 */
public class L21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = null;
        ListNode end = null;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            start = l1;
            end = l1;
            l1 = l1.next;
        } else {
            start = l2;
            end = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                end.next = l1;
                end = end.next;
                l1 = l1.next;
            } else {
                end.next = l2;
                end = end.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            end.next = l2;
        } else if (l2 == null) {
            end.next = l1;
        }

        return start;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;


        ListNode six = new ListNode(5);
        ListNode seven = new ListNode(6);
        ListNode eight = new ListNode(10);
        six.next = seven;
        seven.next = eight;

        ListNode result = mergeTwoLists(one, six);


        System.out.println(result);
    }
}
