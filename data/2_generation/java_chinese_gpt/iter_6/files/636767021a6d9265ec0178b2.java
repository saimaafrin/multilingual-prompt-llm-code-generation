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
            } else {
                throw new EmptyStackException();
            }
        }
    }

    private int getTypeCount(String descriptor) {
        // 这里假设 descriptor 是一个有效的类型描述符
        // 例如 "I" 表示 int, "D" 表示 double, "(II)V" 表示方法参数为两个 int
        int count = 0;
        boolean isMethodDescriptor = descriptor.startsWith("(");
        
        if (isMethodDescriptor) {
            int endIndex = descriptor.indexOf(')');
            if (endIndex != -1) {
                descriptor = descriptor.substring(1, endIndex);
            }
        }

        for (char c : descriptor.toCharArray()) {
            if (c == 'D' || c == 'J') {
                count += 2; // double 和 long 占用两个抽象类型
            } else {
                count += 1; // 其他类型占用一个抽象类型
            }
        }
        return count;
    }
}