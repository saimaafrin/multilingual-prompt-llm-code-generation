import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack;

    public FrameStack() {
        this.stack = new Stack<>();
    }

    public void push(Object value) {
        stack.push(value);
    }

    public Object pop() {
        return stack.pop();
    }

    /**
     * 从输出帧栈中弹出与给定描述符所描述的抽象类型数量。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // 判断描述符是类型描述符还是方法描述符
        if (descriptor.startsWith("(")) {
            // 方法描述符，解析参数类型
            String params = descriptor.substring(1, descriptor.indexOf(')'));
            int index = 0;
            while (index < params.length()) {
                char c = params.charAt(index);
                if (c == 'L') {
                    // 对象类型，找到分号
                    int end = params.indexOf(';', index);
                    if (end == -1) {
                        throw new IllegalArgumentException("Invalid descriptor: " + descriptor);
                    }
                    index = end + 1;
                } else if (c == '[') {
                    // 数组类型，继续读取
                    index++;
                    continue;
                } else if (c == 'D' || c == 'J') {
                    // double 或 long 类型，占用两个槽位
                    stack.pop();
                }
                // 弹出栈顶元素
                stack.pop();
                index++;
            }
        } else {
            // 类型描述符，直接弹出
            if (descriptor.equals("D") || descriptor.equals("J")) {
                // double 或 long 类型，占用两个槽位
                stack.pop();
            }
            stack.pop();
        }
    }
}