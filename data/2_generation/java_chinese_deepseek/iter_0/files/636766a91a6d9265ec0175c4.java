import java.util.Stack;

public class FrameStack {
    private Stack<String> stack = new Stack<>();

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
            String params = descriptor.substring(1, endIndex);
            int paramCount = 0;
            for (int i = 0; i < params.length(); i++) {
                char c = params.charAt(i);
                if (c == 'L') {
                    // 对象类型，跳过直到分号
                    i = params.indexOf(';', i);
                    if (i == -1) {
                        throw new IllegalArgumentException("Invalid object type in descriptor: " + descriptor);
                    }
                } else if (c == '[') {
                    // 数组类型，跳过所有维度
                    while (i < params.length() && params.charAt(i) == '[') {
                        i++;
                    }
                    if (i >= params.length()) {
                        throw new IllegalArgumentException("Invalid array type in descriptor: " + descriptor);
                    }
                    if (params.charAt(i) == 'L') {
                        // 对象数组类型，跳过直到分号
                        i = params.indexOf(';', i);
                        if (i == -1) {
                            throw new IllegalArgumentException("Invalid object array type in descriptor: " + descriptor);
                        }
                    }
                }
                paramCount++;
            }
            // 弹出相应数量的类型
            for (int i = 0; i < paramCount; i++) {
                if (stack.isEmpty()) {
                    throw new IllegalStateException("Stack underflow while popping method parameters");
                }
                stack.pop();
            }
        } else {
            // 单个类型描述符，弹出一个类型
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack underflow while popping single type");
            }
            stack.pop();
        }
    }
}