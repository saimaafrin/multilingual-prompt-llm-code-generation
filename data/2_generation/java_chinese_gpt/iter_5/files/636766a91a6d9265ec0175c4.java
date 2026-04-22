import java.util.Stack;

public class DescriptorPopper {
    private Stack<Object> frameStack;

    public DescriptorPopper() {
        this.frameStack = new Stack<>();
    }

    /**
     * 根据给定的描述符，从输出帧堆栈中弹出相应数量的抽象类型。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则会弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        int count = getCountFromDescriptor(descriptor);
        for (int i = 0; i < count; i++) {
            if (!frameStack.isEmpty()) {
                frameStack.pop();
            } else {
                throw new IllegalStateException("Stack is empty, cannot pop more elements.");
            }
        }
    }

    private int getCountFromDescriptor(String descriptor) {
        // This method should parse the descriptor and return the number of types to pop.
        // For simplicity, let's assume:
        // - "I" = 1 (int)
        // - "D" = 2 (double)
        // - "L" = 1 (object reference)
        // - "V" = 0 (void)
        // - Method descriptors will be handled separately.

        switch (descriptor) {
            case "I":
                return 1;
            case "D":
                return 2;
            case "L":
                return 1;
            case "V":
                return 0;
            default:
                // Handle method descriptors (e.g., "(II)V" means pop 2 ints)
                if (descriptor.startsWith("(") && descriptor.contains(")")) {
                    String params = descriptor.substring(descriptor.indexOf('(') + 1, descriptor.indexOf(')'));
                    return countParameters(params);
                }
                throw new IllegalArgumentException("Unknown descriptor: " + descriptor);
        }
    }

    private int countParameters(String params) {
        int count = 0;
        for (char c : params.toCharArray()) {
            if (c == 'I' || c == 'L') {
                count += 1;
            } else if (c == 'D') {
                count += 2;
            }
        }
        return count;
    }

    public void push(Object obj) {
        frameStack.push(obj);
    }
}