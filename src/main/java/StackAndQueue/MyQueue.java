package StackAndQueue;

import java.util.Stack;

/**
 * @author yaosen.pys
 * @date 2021/08/03
 */
public class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!out.isEmpty()) {
            return out.pop();
        } else {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }

            return out.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!out.isEmpty()) {
            return out.peek();
        } else {

            while(!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
