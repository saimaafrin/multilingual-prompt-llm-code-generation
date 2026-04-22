public class StackManipulator {
    
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
            }
        }
    }

    private int getTypeCount(String descriptor) {
        // 这里假设 descriptor 是一个有效的类型描述符
        // 例如 "I" 表示 int, "D" 表示 double, "(II)V" 表示方法描述符
        // 需要根据实际的描述符解析逻辑来实现
        if (descriptor.startsWith("(")) {
            // 方法描述符，计算参数类型数量
            int paramCount = 0;
            for (int i = 1; i < descriptor.length(); i++) {
                char c = descriptor.charAt(i);
                if (c == ')') {
                    break;
                }
                paramCount += getTypeSize(c);
            }
            return paramCount;
        } else {
            // 类型描述符，返回类型大小
            return getTypeSize(descriptor.charAt(0));
        }
    }

    private int getTypeSize(char type) {
        switch (type) {
            case 'Z': // boolean
            case 'B': // byte
            case 'C': // char
            case 'S': // short
            case 'I': // int
                return 1;
            case 'J': // long
            case 'D': // double
                return 2;
            case 'L': // object reference
                return 1; // 参考类型
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}