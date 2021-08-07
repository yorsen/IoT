package StackAndQueue;

import java.sql.Statement;
import java.util.Stack;

/**
 * @author yaosen.pys
 * @date 2021/08/04
 */
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minData;
    private Integer min;

    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        data.add(val);
        min = Math.min(min, val);
        minData.add(min);
    }

    public int pop() {
        int result = data.pop();
        minData.pop();
        min = minData.isEmpty() ? Integer.MAX_VALUE : minData.peek();

        return result;
    }

    public int top() {
        return data.peek();
    }


    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int getMin() {
        return minData.peek();
    }
}
