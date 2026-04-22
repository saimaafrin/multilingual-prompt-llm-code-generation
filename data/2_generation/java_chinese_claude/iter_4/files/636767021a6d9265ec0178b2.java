import org.objectweb.asm.Type;

public class StackFrameAnalyzer {
    private int currentStackSize;
    
    /**
     * 从输出帧栈中弹出与给定描述符所描述的抽象类型数量。
     * @param descriptor 类型或方法描述符（如果是方法描述符，则弹出其参数类型）。
     */
    private void pop(final String descriptor) {
        String desc = descriptor;
        if (desc.charAt(0) == '(') {
            // 如果是方法描述符,只处理参数部分
            int i = desc.indexOf(')');
            if (i != -1) {
                desc = desc.substring(1, i);
            }
        }
        
        Type[] types = Type.getArgumentTypes(desc);
        for (Type type : types) {
            int size = type.getSize();
            currentStackSize -= size;
        }
    }
}