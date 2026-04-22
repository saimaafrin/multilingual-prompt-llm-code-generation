import java.util.Stack;

public class FrameStack {
    private Stack<Integer> stack;

    public FrameStack() {
        stack = new Stack<>();
    }

    /** 
     * 从输出帧栈中弹出一个抽象类型并返回其值。
     * @return 从输出帧栈中弹出的抽象类型。
     */
    private int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.pop();
    }

    // 示例用法
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.stack.push(10);
        frameStack.stack.push(20);
        System.out.println(frameStack.pop()); // 输出 20
        System.out.println(frameStack.pop()); // 输出 10
    }
}