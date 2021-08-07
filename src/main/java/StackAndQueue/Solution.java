package StackAndQueue;

import java.util.Stack;

/**
 * @author yaosen.pys
 * @date 2021/08/05
 */
public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char schar : s.toCharArray()) {
            switch (schar) {
                case '(':
                    stack.push(schar);
                    break;
                case '[':
                    stack.push(schar);
                    break;
                case '{':
                    stack.push(schar);
                    break;
                case ')':
                    if(stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if(stack.isEmpty()) {
                        return false;
                    }

                    if (stack.peek() == '{') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if(stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '[') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "{}[]()";
        System.out.println(isValid(s));
    }
}
