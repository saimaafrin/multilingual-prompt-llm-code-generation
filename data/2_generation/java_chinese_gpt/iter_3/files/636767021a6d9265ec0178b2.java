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
        // 这里假设 descriptor 是一个有效的类型或方法描述符
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
            // 类型描述符，返回相应的类型大小
            switch (descriptor) {
                case "I": // int
                case "F": // float
                    return 1;
                case "J": // long
                case "D": // double
                    return 2;
                case "L": // 对象类型
                    return 1; // 对象类型视为1个
                default:
                    throw new IllegalArgumentException("未知的描述符: " + descriptor);
            }
        }
    }
}