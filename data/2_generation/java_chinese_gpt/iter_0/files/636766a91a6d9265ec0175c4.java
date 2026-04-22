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
        // 简单示例：假设 descriptor 是一个简单的类型字符
        switch (descriptor) {
            case "I": // int
            case "Z": // boolean
                return 1;
            case "D": // double
            case "J": // long
                return 2;
            case "V": // void (方法返回类型)
                return 0;
            default:
                // 处理方法描述符
                if (descriptor.startsWith("(") && descriptor.contains(")")) {
                    String paramTypes = descriptor.substring(descriptor.indexOf('(') + 1, descriptor.indexOf(')'));
                    return paramTypes.length(); // 每个参数类型都弹出一个
                }
                return 1; // 默认情况
        }
    }

    public void push(Object item) {
        frameStack.push(item);
    }

    public static void main(String[] args) {
        DescriptorPopper popper = new DescriptorPopper();
        popper.push(new Object());
        popper.push(new Object());
        popper.pop("I"); // 弹出一个int类型
        System.out.println("Remaining items in stack: " + popper.frameStack.size());
    }
}