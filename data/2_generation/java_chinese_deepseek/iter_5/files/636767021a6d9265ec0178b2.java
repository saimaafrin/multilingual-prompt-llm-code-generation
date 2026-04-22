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
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        int count = 0;
        if (descriptor.charAt(0) == '(') {
            // 方法描述符，计算参数类型数量
            int i = 1;
            while (i < descriptor.length() && descriptor.charAt(i) != ')') {
                char c = descriptor.charAt(i);
                if (c == 'L') {
                    // 对象类型，跳过直到 ';'
                    while (i < descriptor.length() && descriptor.charAt(i) != ';') {
                        i++;
                    }
                    i++;
                } else if (c == '[') {
                    // 数组类型，跳过所有 '['
                    while (i < descriptor.length() && descriptor.charAt(i) == '[') {
                        i++;
                    }
                    if (i < descriptor.length() && descriptor.charAt(i) == 'L') {
                        // 对象数组类型，跳过直到 ';'
                        while (i < descriptor.length() && descriptor.charAt(i) != ';') {
                            i++;
                        }
                        i++;
                    } else {
                        // 基本类型数组
                        i++;
                    }
                } else {
                    // 基本类型
                    i++;
                }
                count++;
            }
        } else {
            // 类型描述符，直接弹出1个
            count = 1;
        }

        // 弹出相应数量的元素
        for (int i = 0; i < count; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    // 其他方法...
}