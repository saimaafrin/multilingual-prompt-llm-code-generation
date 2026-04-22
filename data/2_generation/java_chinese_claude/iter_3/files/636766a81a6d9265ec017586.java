import java.util.Stack;

public class FrameStack {
    private Stack<Object> outputStack;

    public FrameStack() {
        outputStack = new Stack<>();
    }

    /**
     * 从输出帧栈中弹出给定数量的抽象类型。
     * @param elements 需弹出的抽象类型数量。
     */
    private void pop(final int elements) {
        for (int i = 0; i < elements && !outputStack.isEmpty(); i++) {
            outputStack.pop();
        }
    }
}