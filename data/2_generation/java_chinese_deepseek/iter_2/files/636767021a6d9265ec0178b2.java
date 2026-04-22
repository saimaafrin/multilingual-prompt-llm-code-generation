import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack;

    public FrameStack() {
        this.stack = new Stack<>();
    }

    /**
     * 从输出帧栈中弹出与给定描述符所描述的抽象类型数量。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        int count = getTypeCount(descriptor);
        for (int i = 0; i < count; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                throw new IllegalStateException("Stack underflow: attempted to pop from an empty stack.");
            }
        }
    }

    /**
     * 根据描述符计算需要弹出的类型数量。
     * @param descriptor 类型或方法描述符。
     * @return 需要弹出的类型数量。
     */
    private int getTypeCount(String descriptor) {
        int count = 0;
        int index = 0;
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            if (c == 'L') {
                // 对象类型，例如 Ljava/lang/Object;
                index = descriptor.indexOf(';', index) + 1;
                count++;
            } else if (c == '[') {
                // 数组类型，例如 [I
                index++;
                count++;
            } else if (c == '(') {
                // 方法描述符的开始，跳过
                index++;
            } else if (c == ')') {
                // 方法描述符的结束，跳过
                index++;
            } else {
                // 基本类型，例如 I, J, D, F
                index++;
                count++;
            }
        }
        return count;
    }

    // 示例用法
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.stack.push(1);
        frameStack.stack.push(2);
        frameStack.stack.push(3);

        frameStack.pop("I"); // 弹出1个int类型
        System.out.println(frameStack.stack); // 输出 [1, 2]

        frameStack.pop("(II)V"); // 弹出2个int类型
        System.out.println(frameStack.stack); // 输出 []
    }
}