import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack = new Stack<>();

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
                throw new IllegalStateException("Stack underflow");
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
                // 对象类型，跳过直到分号
                while (index < descriptor.length() && descriptor.charAt(index) != ';') {
                    index++;
                }
                count++;
            } else if (c == '[') {
                // 数组类型，跳过所有数组维度
                while (index < descriptor.length() && descriptor.charAt(index) == '[') {
                    index++;
                }
                // 处理数组元素类型
                if (index < descriptor.length() && descriptor.charAt(index) == 'L') {
                    while (index < descriptor.length() && descriptor.charAt(index) != ';') {
                        index++;
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
            index++;
        }
        return count;
    }

    // 其他方法...
}