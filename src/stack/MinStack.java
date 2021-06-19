package stack;

import java.util.Stack;

/**
 * Created by zb on 2021/6/11 16:10
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * <p>
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * <p>
 * minStack.min();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MinStack {

    private final Stack<Integer> stackA; // 主栈，记录所有元素
    private final Stack<Integer> stackB;// 辅栈，

    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    /**
     * 入栈 要求  O(1) 时间复杂度
     */
    void push(int x) {
        stackA.add(x);
        if (stackB.isEmpty() || stackB.peek() >= x) { // B 空栈、或者B栈顶大于要添加的元素时入栈。
            stackB.add(x);
        }
    }

    /**
     * 出栈
     */
    void pop() {
        if (stackA.pop().equals(stackB.peek())) { // A 出栈。   B栈顶和A栈顶相同时也出栈。
            stackB.pop();
        }
    }

    /**
     * 查看栈顶
     */
    int top() {
        return stackA.peek();
    }

    /**
     * 最小元素查找. 要求时间负责度
     */
    int min() {
        return stackB.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
      //  System.out.println("min():" + minStack.min());

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());


        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
