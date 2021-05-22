package TwoPointer;

/**
 * @author yaosen.pys
 * @date 2021/05/15
 */
public class L141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = first.next;

        while (first != null && second != null && second.next != null) {
            if (first == second) {
                return true;
            }

            first = first.next;
            second = second.next.next;
        }

        return false;
    }
}
