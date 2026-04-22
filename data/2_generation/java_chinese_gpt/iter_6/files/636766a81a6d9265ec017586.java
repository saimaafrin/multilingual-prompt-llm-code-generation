public class Stack {
    private final List<Object> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    /**
     * 从输出帧栈中弹出给定数量的抽象类型。
     * @param elements 需弹出的抽象类型数量。
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Elements to pop must be non-negative.");
        }
        if (elements > stack.size()) {
            throw new IllegalArgumentException("Not enough elements in the stack to pop.");
        }
        for (int i = 0; i < elements; i++) {
            stack.remove(stack.size() - 1);
        }
    }

    public void push(Object element) {
        stack.add(element);
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push("Element 1");
        myStack.push("Element 2");
        myStack.push("Element 3");
        
        System.out.println("Stack size before pop: " + myStack.size());
        myStack.pop(2);
        System.out.println("Stack size after popping 2 elements: " + myStack.size());
    }
}