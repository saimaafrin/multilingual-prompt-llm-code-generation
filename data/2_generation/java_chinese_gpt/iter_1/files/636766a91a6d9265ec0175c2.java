public class StackExample {
    private java.util.Stack<Integer> outputFrameStack;

    public StackExample() {
        outputFrameStack = new java.util.Stack<>();
    }

    /** 
     * 从输出帧栈中弹出一个抽象类型并返回其值。
     * @return 从输出帧栈中弹出的抽象类型。
     */
    private int pop() {
        if (outputFrameStack.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return outputFrameStack.pop();
    }

    public void push(int value) {
        outputFrameStack.push(value);
    }

    public static void main(String[] args) {
        StackExample stackExample = new StackExample();
        stackExample.push(10);
        stackExample.push(20);
        System.out.println(stackExample.pop()); // Outputs: 20
        System.out.println(stackExample.pop()); // Outputs: 10
    }
}