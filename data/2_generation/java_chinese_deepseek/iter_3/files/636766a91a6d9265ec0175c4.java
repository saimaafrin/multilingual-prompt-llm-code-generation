import java.util.Stack;

public class FrameStack {
    private Stack<String> stack;

    public FrameStack() {
        stack = new Stack<>();
    }

    /**
     * 根据给定的描述符，从输出帧堆栈中弹出相应数量的抽象类型。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则会弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // 判断描述符是否为方法描述符
        if (descriptor.startsWith("(")) {
            // 方法描述符，解析参数类型
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                throw new IllegalArgumentException("Invalid method descriptor: " + descriptor);
            }

            String paramsDescriptor = descriptor.substring(1, endIndex);
            int paramCount = getParamCount(paramsDescriptor);

            // 弹出相应数量的抽象类型
            for (int i = 0; i < paramCount; i++) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    throw new IllegalStateException("Stack underflow");
                }
            }
        } else {
            // 单个类型描述符，弹出一个抽象类型
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                throw new IllegalStateException("Stack underflow");
            }
        }
    }

    /**
     * 计算参数描述符中的参数数量。
     * @param paramsDescriptor 参数描述符
     * @return 参数数量
     */
    private int getParamCount(String paramsDescriptor) {
        int count = 0;
        int index = 0;
        while (index < paramsDescriptor.length()) {
            char c = paramsDescriptor.charAt(index);
            if (c == 'L') {
                // 对象类型，跳过直到分号
                int endIndex = paramsDescriptor.indexOf(';', index);
                if (endIndex == -1) {
                    throw new IllegalArgumentException("Invalid descriptor: " + paramsDescriptor);
                }
                index = endIndex + 1;
            } else if (c == '[') {
                // 数组类型，跳过所有数组维度
                while (index < paramsDescriptor.length() && paramsDescriptor.charAt(index) == '[') {
                    index++;
                }
                if (index < paramsDescriptor.length() && paramsDescriptor.charAt(index) == 'L') {
                    // 对象数组类型，跳过直到分号
                    int endIndex = paramsDescriptor.indexOf(';', index);
                    if (endIndex == -1) {
                        throw new IllegalArgumentException("Invalid descriptor: " + paramsDescriptor);
                    }
                    index = endIndex + 1;
                } else {
                    // 基本类型数组，跳过基本类型字符
                    index++;
                }
            } else {
                // 基本类型，跳过基本类型字符
                index++;
            }
            count++;
        }
        return count;
    }

    // 其他方法...
}