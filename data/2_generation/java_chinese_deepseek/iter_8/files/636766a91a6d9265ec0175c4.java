import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack;

    public FrameStack() {
        this.stack = new Stack<>();
    }

    /**
     * 根据给定的描述符，从输出帧堆栈中弹出相应数量的抽象类型。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则会弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        int count = 0;
        if (descriptor.charAt(0) == '(') {
            // 方法描述符，计算参数类型的数量
            int i = 1;
            while (i < descriptor.length() && descriptor.charAt(i) != ')') {
                char c = descriptor.charAt(i);
                if (c == 'L') {
                    // 对象类型，跳过直到分号
                    while (i < descriptor.length() && descriptor.charAt(i) != ';') {
                        i++;
                    }
                    count++;
                } else if (c == '[') {
                    // 数组类型，跳过所有数组维度
                    while (i < descriptor.length() && descriptor.charAt(i) == '[') {
                        i++;
                    }
                    if (i < descriptor.length() && descriptor.charAt(i) == 'L') {
                        // 对象数组类型，跳过直到分号
                        while (i < descriptor.length() && descriptor.charAt(i) != ';') {
                            i++;
                        }
                    }
                    count++;
                } else if (c == 'D' || c == 'J') {
                    // double 或 long 类型，占用两个槽位
                    count += 2;
                } else {
                    // 其他基本类型，占用一个槽位
                    count++;
                }
                i++;
            }
        } else {
            // 单个类型描述符
            if (descriptor.charAt(0) == 'L') {
                // 对象类型
                count = 1;
            } else if (descriptor.charAt(0) == '[') {
                // 数组类型
                count = 1;
            } else if (descriptor.charAt(0) == 'D' || descriptor.charAt(0) == 'J') {
                // double 或 long 类型，占用两个槽位
                count = 2;
            } else {
                // 其他基本类型，占用一个槽位
                count = 1;
            }
        }

        // 弹出相应数量的元素
        for (int i = 0; i < count; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    public void push(Object obj) {
        stack.push(obj);
    }

    public Object peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}