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

        if (descriptor.startsWith("(")) {
            // 方法描述符，需要解析参数类型
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                throw new IllegalArgumentException("Invalid method descriptor: " + descriptor);
            }
            String paramsDescriptor = descriptor.substring(1, endIndex);
            popTypes(paramsDescriptor);
        } else {
            // 单个类型描述符
            popType(descriptor);
        }
    }

    private void popTypes(String paramsDescriptor) {
        int index = 0;
        while (index < paramsDescriptor.length()) {
            char c = paramsDescriptor.charAt(index);
            if (c == 'L') {
                // 对象类型，以 ';' 结尾
                int endIndex = paramsDescriptor.indexOf(';', index);
                if (endIndex == -1) {
                    throw new IllegalArgumentException("Invalid object type descriptor: " + paramsDescriptor);
                }
                stack.pop();
                index = endIndex + 1;
            } else if (c == '[') {
                // 数组类型
                stack.pop();
                index++;
            } else {
                // 基本类型
                stack.pop();
                index++;
            }
        }
    }

    private void popType(String typeDescriptor) {
        if (typeDescriptor.startsWith("L") || typeDescriptor.startsWith("[")) {
            // 对象类型或数组类型
            stack.pop();
        } else {
            // 基本类型
            stack.pop();
        }
    }

    // 其他方法...
}