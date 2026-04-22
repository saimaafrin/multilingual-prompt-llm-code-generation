public class StackManipulator {
    private final Stack<Object> stack = new Stack<>();

    /** 
     * 从输出帧栈中弹出与给定描述符所描述的抽象类型数量。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        int count = getTypeCount(descriptor);
        for (int i = 0; i < count; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    private int getTypeCount(String descriptor) {
        // 这里假设 descriptor 是一个有效的类型描述符
        // 例如 "I" 表示 int，"D" 表示 double，"(II)V" 表示方法参数为两个 int
        // 这个方法需要解析 descriptor 并返回相应的类型数量
        if (descriptor.startsWith("(")) {
            // 方法描述符，计算参数类型数量
            int count = 0;
            for (char c : descriptor.toCharArray()) {
                if (c == '(') {
                    continue;
                } else if (c == ')') {
                    break;
                } else {
                    count++;
                }
            }
            return count;
        } else {
            // 类型描述符，返回相应的类型数量
            switch (descriptor) {
                case "I": // int
                case "F": // float
                    return 1;
                case "D": // double
                case "J": // long
                    return 2; // long and double take two slots
                default:
                    return 1; // 默认处理
            }
        }
    }
}