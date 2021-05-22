package List;

import java.util.Stack;

import common.ListNode;

/**
 * @author yaosen.pys
 * @date 2021/05/18
 */
public class L445 {
    //(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出：7 -> 8 -> 0 -> 7
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = parseStack(l1);
        Stack<Integer> l2Stack = parseStack(l2);
        Stack<Integer> result = new Stack<Integer>();
        int up = 0;
        while (!l1Stack.empty() || !l2Stack.empty()) {
            int l1Value = l1Stack.empty() ? 0 : l1Stack.pop();
            int l2Value = l2Stack.empty() ? 0 : l2Stack.pop();
            int temp = up + l1Value + l2Value;
            if (temp < 10) {
                result.push(temp);
                up = 0;
            } else {
                up = 1;
                temp = temp - 10;
                result.push(temp);
            }
        }

        if (up > 0) {
            result.push(up);
        }

        return parseList(result);
    }

    private static Stack<Integer> parseStack(ListNode l1) {
        Stack<Integer> result = new Stack<Integer>();
        while (l1 != null) {
            result.push(l1.val);
            l1 = l1.next;
        }

        return result;
    }

    private static ListNode parseList(Stack<Integer> stack) {
        if (stack.empty()) {
            return null;
        }

        ListNode result = new ListNode(stack.pop());
        ListNode nextNode = result;
        while (!stack.empty()) {
            ListNode temp = new ListNode(stack.pop());
            nextNode.next = temp;
            nextNode = nextNode.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(9);
        ListNode two = new ListNode(9);
        ListNode three = new ListNode(9);
        ListNode four = new ListNode(9);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode six = new ListNode(1);
        ListNode seven = new ListNode(9);
        ListNode eight = new ListNode(9);
        //six.next = seven;
       // seven.next = eight;

        ListNode.print(addTwoNumbers(one, null));

    }
}
