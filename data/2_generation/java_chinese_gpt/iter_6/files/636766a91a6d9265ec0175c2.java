public class StackExample {
    private int[] stack;
    private int top;

    public StackExample(int size) {
        stack = new int[size];
        top = -1;
    }

    /** 
     * 从输出帧栈中弹出一个抽象类型并返回其值。
     * @return 从输出帧栈中弹出的抽象类型。
     */
    private int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = value;
    }

    public static void main(String[] args) {
        StackExample stackExample = new StackExample(5);
        stackExample.push(10);
        stackExample.push(20);
        System.out.println(stackExample.pop()); // Outputs: 20
        System.out.println(stackExample.pop()); // Outputs: 10
    }
}