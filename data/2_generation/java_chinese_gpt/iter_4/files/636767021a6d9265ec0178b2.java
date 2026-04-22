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
        if (descriptor == null || descriptor.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (char c : descriptor.toCharArray()) {
            if (c == 'L') {
                count++; // Object type
                while (c != ';') {
                    c = descriptor.charAt(++count);
                }
            } else if (c == '[') {
                count++; // Array type
            } else {
                count++; // Primitive type
            }
        }
        return count;
    }

    public void push(Object item) {
        stack.push(item);
    }

    public Object peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}