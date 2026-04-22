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
        // 简单示例：假设 descriptor 是一个字符串，表示类型
        // 例如 "I" 表示 int 类型，"D" 表示 double 类型等
        // 这里的实现可以根据实际需求进行扩展
        switch (descriptor) {
            case "I": // int
                return 1;
            case "D": // double
                return 2;
            case "V": // void
                return 0;
            // 可以添加更多类型的处理
            default:
                throw new IllegalArgumentException("Unsupported descriptor: " + descriptor);
        }
    }

    public void push(Object item) {
        frameStack.push(item);
    }

    public static void main(String[] args) {
        DescriptorPopper popper = new DescriptorPopper();
        popper.push(1);
        popper.push(2.0);
        popper.pop("I"); // 弹出一个 int 类型
        System.out.println("Pop operation completed.");
    }
}