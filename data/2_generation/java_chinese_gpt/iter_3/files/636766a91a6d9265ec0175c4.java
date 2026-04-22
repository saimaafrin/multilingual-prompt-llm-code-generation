public class StackManipulator {
    
    private Stack<Object> stack = new Stack<>();

    /** 
     * 根据给定的描述符，从输出帧堆栈中弹出相应数量的抽象类型。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则会弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        int count = getCountFromDescriptor(descriptor);
        for (int i = 0; i < count; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                throw new EmptyStackException();
            }
        }
    }

    private int getCountFromDescriptor(String descriptor) {
        // 这里可以根据描述符解析出需要弹出的数量
        // 假设我们只处理基本类型和对象类型
        if (descriptor.equals("V")) {
            return 0; // void类型不弹出
        } else if (descriptor.startsWith("(")) {
            // 方法描述符，计算参数数量
            int paramCount = 0;
            for (char c : descriptor.toCharArray()) {
                if (c == '(') continue;
                if (c == ')') break;
                paramCount++;
            }
            return paramCount;
        } else {
            // 处理单一类型
            return 1; // 默认弹出一个
        }
    }

    public void push(Object item) {
        stack.push(item);
    }
}