import java.util.Stack;

public class DescriptorPopper {
    private Stack<Object> outputFrameStack;

    public DescriptorPopper() {
        this.outputFrameStack = new Stack<>();
    }

    /**
     * 根据给定的描述符，从输出帧堆栈中弹出相应数量的抽象类型。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则会弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        int count = getCountFromDescriptor(descriptor);
        for (int i = 0; i < count; i++) {
            if (!outputFrameStack.isEmpty()) {
                outputFrameStack.pop();
            } else {
                throw new IllegalStateException("Stack is empty, cannot pop more elements.");
            }
        }
    }

    private int getCountFromDescriptor(String descriptor) {
        // This is a simplified version of counting based on descriptor.
        // In a real scenario, you would parse the descriptor string properly.
        if (descriptor.startsWith("(")) {
            // Method descriptor, count parameters
            return (descriptor.split(";").length - 1) / 2; // Simplified count
        } else {
            // Type descriptor, count based on type length
            return descriptor.length(); // Simplified count
        }
    }

    public void push(Object item) {
        outputFrameStack.push(item);
    }

    public static void main(String[] args) {
        DescriptorPopper popper = new DescriptorPopper();
        popper.push(new Object());
        popper.push(new Object());
        popper.push(new Object());

        // Example usage
        popper.pop("(II)V"); // Assuming this pops 2 items for the method descriptor
    }
}