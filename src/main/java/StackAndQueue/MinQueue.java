package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yaosen.pys
 * @date 2021/08/05
 */
public class MinQueue {
    private MinStack in;
    private MinStack out;

    public MinQueue() {
        in = new MinStack();
        out = new MinStack();
    }

    public void push(int val) {
        in.push(val);
    }

    public void pop() {
        if (!out.isEmpty()) {
            out.pop();
        } else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            out.pop();
        }
    }

    public int peek() {
        if (!out.isEmpty()) {
            return out.top();
        } else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.top();
        }
    }

    public int getMin() {
        return Math.min(in.getMin(), out.getMin());
    }

    public static void main(String[] args) {

    }
}
