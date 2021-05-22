package TwoPointer;

/**
 * @author yaosen.pys
 * @date 2021/05/16
 */
public class L160 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;

        while (first != second) {
            first = first == null ? headB : first.next;
            second = second == null ? headA : second.next;
        }

        return first;
    }
}


