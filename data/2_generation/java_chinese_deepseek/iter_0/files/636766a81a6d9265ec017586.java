import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack;

    public FrameStack() {
        stack = new Stack<>();
    }

    /** 
     * 从输出帧栈中弹出给定数量的抽象类型。
     * @param elements 需弹出的抽象类型数量。
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Number of elements to pop cannot be negative.");
        }
        if (stack.size() < elements) {
            throw new IllegalStateException("Not enough elements in the stack to pop.");
        }
        for (int i = 0; i < elements; i++) {
            stack.pop();
        }
    }

    // Example usage
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.stack.push("Element1");
        frameStack.stack.push("Element2");
        frameStack.stack.push("Element3");

        frameStack.pop(2); // Pops the last two elements
        System.out.println(frameStack.stack); // Output: [Element1]
    }
}