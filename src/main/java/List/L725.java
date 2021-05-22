package List;

import common.ListNode;

/**
 * @author yaosen.pys
 * @date 2021/05/20
 */
public class L725 {
    public static ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;

        ListNode first = root;
        while (first != null) {
            length++;
            first = first.next;
        }

        int mod = length % k;
        int size = length / k;

        ListNode[] result = new ListNode[k];

        ListNode cur = root;
        for (int i = 0; cur != null &&  i < k ; i++) {
            int curSize = size + (mod-- > 0 ? 1 : 0);
            result[i] = cur;
            for (int j = 0; j < curSize-1; j++) {
                cur = cur.next;
            }
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        //four.next = five;

        ListNode[] result = splitListToParts(one, 5);

        System.out.println("ok");
    }
}
