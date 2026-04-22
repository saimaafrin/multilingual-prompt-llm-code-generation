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
        // 例如 "I" 表示 int，"D" 表示 double，"Lcom/example/MyClass;" 表示对象类型
        // 方法描述符的参数类型需要解析
        if (descriptor.startsWith("(")) {
            // 方法描述符，计算参数类型数量
            int count = 0;
            for (int i = 1; i < descriptor.length(); i++) {
                char c = descriptor.charAt(i);
                if (c == ')') {
                    break;
                }
                if (c == 'L') {
                    // 对象类型
                    while (i < descriptor.length() && descriptor.charAt(i) != ';') {
                        i++;
                    }
                    count++;
                } else if (c == '[') {
                    // 数组类型
                    while (i < descriptor.length() && descriptor.charAt(i) == '[') {
                        i++;
                    }
                    if (i < descriptor.length() && descriptor.charAt(i) == 'L') {
                        while (i < descriptor.length() && descriptor.charAt(i) != ';') {
                            i++;
                        }
                    }
                    count++;
                } else {
                    // 基本类型
                    count++;
                }
            }
            return count;
        } else {
            // 基本类型或对象类型
            return getBasicTypeCount(descriptor);
        }
    }

    private int getBasicTypeCount(String descriptor) {
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
            default:
                // 对象类型
                return 1; // 视为一个对象
        }
    }
}