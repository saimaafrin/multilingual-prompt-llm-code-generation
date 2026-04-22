import java.util.Stack;

public class DescriptorPopper {
    private Stack<Object> outputFrameStack;

    public DescriptorPopper() {
        outputFrameStack = new Stack<>();
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
            }
        }
    }

    private int getCountFromDescriptor(String descriptor) {
        // 这里可以根据描述符解析出需要弹出的数量
        // 简单示例：假设 descriptor 是一个字符串，表示类型的数量
        // 例如 "I" 表示一个 int 类型，"II" 表示两个 int 类型
        return descriptor.length(); // 这里简单返回长度作为示例
    }

    public void push(Object item) {
        outputFrameStack.push(item);
    }

    public static void main(String[] args) {
        DescriptorPopper popper = new DescriptorPopper();
        popper.push(new Object());
        popper.push(new Object());
        popper.push(new Object());

        System.out.println("Stack size before pop: " + popper.outputFrameStack.size());
        popper.pop("II"); // 假设我们要弹出两个对象
        System.out.println("Stack size after pop: " + popper.outputFrameStack.size());
    }
}