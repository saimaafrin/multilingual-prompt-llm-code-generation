public class Stack {
    private java.util.Stack<Object> stack;

    public Stack() {
        stack = new java.util.Stack<>();
    }

    /** 
     * 从输出帧栈中弹出给定数量的抽象类型。
     * @param elements 需弹出的抽象类型数量。
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Number of elements to pop cannot be negative.");
        }
        for (int i = 0; i < elements; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                break; // Stop if the stack is empty
            }
        }
    }

    // Method to push elements onto the stack for testing purposes
    public void push(Object element) {
        stack.push(element);
    }

    // Method to check the current size of the stack for testing purposes
    public int size() {
        return stack.size();
    }
}