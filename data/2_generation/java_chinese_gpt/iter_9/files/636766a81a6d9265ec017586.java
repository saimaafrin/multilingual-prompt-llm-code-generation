public class StackExample {
    private java.util.Stack<Object> stack;

    public StackExample() {
        stack = new java.util.Stack<>();
    }

    /** 
     * 从输出帧栈中弹出给定数量的抽象类型。
     * @param elements 需弹出的抽象类型数量。
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Elements to pop must be non-negative.");
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

    // Method to get the current size of the stack for testing purposes
    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        StackExample example = new StackExample();
        example.push("Element 1");
        example.push("Element 2");
        example.push("Element 3");
        
        System.out.println("Stack size before pop: " + example.size());
        example.pop(2);
        System.out.println("Stack size after popping 2 elements: " + example.size());
    }
}