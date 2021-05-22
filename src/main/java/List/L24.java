package List;

import common.ListNode;

/**
 * @author yaosen.pys
 * @date 2021/05/18
 */
public class L24 {
    public static  ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        head = second;
        ListNode temp = null;
        while (true) {
            first.next = second.next;
            second.next = first;
            if(temp != null) {
                temp.next = second;
            }
            temp = first;

            if (first.next == null) {
                break;
            } else {
                first = first.next;
            }

            if (first.next == null) {
                break;
            } else {
                second = first.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

       // one.next = two;
       // two.next = three;
        //three.next = four;
        //four.next = five;

        ListNode result = swapPairs(null);


        ListNode.print(result);
    }
}
