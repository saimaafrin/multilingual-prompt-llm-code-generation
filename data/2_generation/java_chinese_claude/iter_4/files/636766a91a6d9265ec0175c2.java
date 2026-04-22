public class Stack {
    private int[] stack;
    private int top;
    private static final int DEFAULT_SIZE = 1000;

    public Stack() {
        stack = new int[DEFAULT_SIZE];
        top = -1;
    }

    /**
     * 从输出帧栈中弹出一个抽象类型并返回其值。
     * @return 从输出帧栈中弹出的抽象类型。
     * @throws IllegalStateException 当栈为空时抛出异常
     */
    private int pop() {
        if (top < 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }
}