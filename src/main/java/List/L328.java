package List;

import common.ListNode;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/description/
 * @author yaosen.pys
 * @date 2021/05/22
 */
public class L328 {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode singleEnd = head;
        ListNode doubleFirst = head.next;
        ListNode next = head.next;

        while (next != null && next.next != null) {
            ListNode temp = next.next;
            ListNode tempNext = next.next.next;
            singleEnd.next = temp;
            temp.next = doubleFirst;
            next.next = tempNext;
            next = tempNext;
            singleEnd = singleEnd.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        ListNode temp = oddEvenList(one);
        ListNode.print(temp);
    }

}
