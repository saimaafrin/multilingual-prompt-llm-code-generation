import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack = new Stack<>();

    /**
     * 根据给定的描述符，从输出帧堆栈中弹出相应数量的抽象类型。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则会弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // 判断是否是方法描述符
        if (descriptor.startsWith("(")) {
            // 方法描述符，解析参数类型
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                throw new IllegalArgumentException("Invalid method descriptor: " + descriptor);
            }
            String paramsDescriptor = descriptor.substring(1, endIndex);
            int paramCount = getParameterCount(paramsDescriptor);
            for (int i = 0; i < paramCount; i++) {
                stack.pop();
            }
        } else {
            // 单个类型描述符
            stack.pop();
        }
    }

    /**
     * 计算参数描述符中的参数数量。
     * @param paramsDescriptor 参数描述符
     * @return 参数数量
     */
    private int getParameterCount(String paramsDescriptor) {
        int count = 0;
        int index = 0;
        while (index < paramsDescriptor.length()) {
            char c = paramsDescriptor.charAt(index);
            if (c == 'L') {
                // 对象类型，跳过直到分号
                index = paramsDescriptor.indexOf(';', index) + 1;
            } else if (c == '[') {
                // 数组类型，跳过所有数组维度
                while (index < paramsDescriptor.length() && paramsDescriptor.charAt(index) == '[') {
                    index++;
                }
                if (index < paramsDescriptor.length() && paramsDescriptor.charAt(index) == 'L') {
                    // 对象数组类型，跳过直到分号
                    index = paramsDescriptor.indexOf(';', index) + 1;
                } else {
                    // 基本类型数组，跳过基本类型字符
                    index++;
                }
            } else {
                // 基本类型，直接跳过
                index++;
            }
            count++;
        }
        return count;
    }

    // 测试代码
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.stack.push("int");
        frameStack.stack.push("double");
        frameStack.stack.push("Object");

        frameStack.pop("(IDLjava/lang/Object;)V");

        System.out.println(frameStack.stack); // 输出: []
    }
}