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
            }
        }
    }

    private int getCountFromDescriptor(String descriptor) {
        // 这里可以根据描述符解析出需要弹出的数量
        // 简化处理：假设 descriptor 是一个简单的类型描述符
        switch (descriptor) {
            case "I": // int
            case "F": // float
                return 1;
            case "J": // long
            case "D": // double
                return 2;
            default: // 其他类型
                return 1; // 默认返回1
        }
    }

    public void push(Object item) {
        frameStack.push(item);
    }

    public static void main(String[] args) {
        DescriptorPopper popper = new DescriptorPopper();
        popper.push(1);
        popper.push(2.0);
        popper.pop("I"); // 弹出一个int类型
        System.out.println("Pop operation completed.");
    }
}