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
        int count = 0;
        if (descriptor.startsWith("(")) {
            // Method descriptor, count parameters
            int i = 1;
            while (descriptor.charAt(i) != ')') {
                if (descriptor.charAt(i) == 'L') {
                    // Object type
                    while (descriptor.charAt(i) != ';') {
                        i++;
                    }
                    i++; // Move past ';'
                } else if (descriptor.charAt(i) == '[') {
                    // Array type
                    while (descriptor.charAt(i) == '[') {
                        i++;
                    }
                    if (descriptor.charAt(i) == 'L') {
                        while (descriptor.charAt(i) != ';') {
                            i++;
                        }
                        i++; // Move past ';'
                    }
                } else {
                    // Primitive type
                    i++;
                }
                count++;
            }
        } else {
            // Type descriptor, count based on type
            if (descriptor.equals("V")) {
                count = 0; // Void type
            } else if (descriptor.equals("Z") || descriptor.equals("B") || descriptor.equals("C") || 
                       descriptor.equals("S") || descriptor.equals("I")) {
                count = 1; // 1 for primitive types
            } else if (descriptor.equals("F") || descriptor.equals("D")) {
                count = 1; // 1 for float/double
            } else if (descriptor.startsWith("L")) {
                count = 1; // Object type
            } else if (descriptor.startsWith("[")) {
                count = 1; // Array type
            }
        }
        return count;
    }
}