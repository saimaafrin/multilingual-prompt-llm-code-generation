public class FrameStack {
    private java.util.Stack<Integer> stack;

    public FrameStack() {
        stack = new java.util.Stack<>();
    }

    /** 
     * 从输出帧栈中弹出一个抽象类型并返回其值。
     * @return 从输出帧栈中弹出的抽象类型。
     */
    private int pop() {
        if (stack.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return stack.pop();
    }

    public void push(int value) {
        stack.push(value);
    }

    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.push(10);
        frameStack.push(20);
        System.out.println(frameStack.pop()); // Outputs: 20
        System.out.println(frameStack.pop()); // Outputs: 10
    }
}