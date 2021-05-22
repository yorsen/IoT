package List;

import common.ListNode;

/**
 * @author yaosen.pys
 * @date 2021/05/20
 */
public class L234 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head;

        while (true) {
            if(second.next == null || second.next.next == null) {
                break;
            }

            first = first.next;
            second = second.next.next;
        }

        ListNode reverseList = reverse(first.next);
        first = first.next;

        ListNode begin = head;

        while (reverseList != null) {
            if (begin.val != reverseList.val) {
                return false;
            }

            begin = begin.next;
            reverseList = reverseList.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode first = head;
        first = first.next;
        head.next = null;

        while (first != null) {
            ListNode temp = first.next;
            first.next = head;
            head = first;
            first = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(0);
       // ListNode five = new ListNode(1);

       // one.next = two;
       // two.next = three;
        //three.next = four;
       // four.next = five;
        //ListNode temp = reverse(one);
        //ListNode.print(temp);

        System.out.println(isPalindrome(one));
    }
}
