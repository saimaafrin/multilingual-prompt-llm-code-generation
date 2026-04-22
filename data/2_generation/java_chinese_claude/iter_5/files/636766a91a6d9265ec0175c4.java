import org.objectweb.asm.Type;

public class StackFrameAnalyzer {
    private Frame currentFrame;
    
    /**
     * 根据给定的描述符，从输出帧堆栈中弹出相应数量的抽象类型。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则会弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        String desc = descriptor;
        if (desc.charAt(0) == '(') {
            // Method descriptor - pop parameter types
            Type[] types = Type.getArgumentTypes(desc);
            for (int i = types.length - 1; i >= 0; i--) {
                Type type = types[i];
                if (type.getSize() == 2) {
                    currentFrame.pop2();
                } else {
                    currentFrame.pop();
                }
            }
            return;
        }
        
        // Type descriptor - pop single type
        Type type = Type.getType(desc);
        if (type.getSize() == 2) {
            currentFrame.pop2();
        } else {
            currentFrame.pop();
        }
    }
}