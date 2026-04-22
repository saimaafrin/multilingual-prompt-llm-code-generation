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
        // 例如： "I" 表示 int, "D" 表示 double, "(II)V" 表示两个 int 参数的方法
        if (descriptor.startsWith("(")) {
            // 方法描述符，计算参数类型数量
            int paramCount = 0;
            int i = 1; // 跳过开括号
            while (descriptor.charAt(i) != ')') {
                if (descriptor.charAt(i) == 'L') {
                    // 对象类型
                    while (descriptor.charAt(i) != ';') {
                        i++;
                    }
                    i++; // 跳过分号
                } else {
                    // 基本类型
                    i++;
                }
                paramCount++;
            }
            return paramCount;
        } else {
            // 类型描述符，返回基本类型的数量
            switch (descriptor) {
                case "V": return 0; // void
                case "Z": return 1; // boolean
                case "B": return 1; // byte
                case "C": return 1; // char
                case "S": return 1; // short
                case "I": return 1; // int
                case "J": return 2; // long
                case "F": return 1; // float
                case "D": return 2; // double
                case "L": return 1; // 对象类型
                default: throw new IllegalArgumentException("Invalid descriptor: " + descriptor);
            }
        }
    }
}