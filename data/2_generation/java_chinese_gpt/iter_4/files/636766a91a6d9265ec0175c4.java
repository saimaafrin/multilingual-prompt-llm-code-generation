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
        // 简单示例：假设 descriptor 是 "I" 表示 int 类型，"D" 表示 double 类型
        switch (descriptor) {
            case "I":
                return 1; // int 类型
            case "D":
                return 2; // double 类型
            case "V":
                return 0; // void 类型
            // 其他类型的处理可以在这里添加
            default:
                return 1; // 默认返回 1
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