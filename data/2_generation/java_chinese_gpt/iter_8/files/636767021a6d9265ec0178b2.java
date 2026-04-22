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
            int index = 1; // Start after '('
            while (descriptor.charAt(index) != ')') {
                if (descriptor.charAt(index) == 'L') {
                    // Object type
                    while (descriptor.charAt(index) != ';') {
                        index++;
                    }
                    index++; // Move past ';'
                } else {
                    // Primitive type
                    index++;
                }
                count++;
            }
        } else {
            // Type descriptor
            if (descriptor.charAt(0) == 'L') {
                // Object type
                count = 1;
            } else {
                // Primitive type
                count = 1;
            }
        }
        return count;
    }
}