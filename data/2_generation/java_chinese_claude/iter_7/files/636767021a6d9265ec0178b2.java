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
        
        // 计算描述符中的类型数量
        int typeCount = 0;
        for (int i = 0; i < desc.length(); i++) {
            char c = desc.charAt(i);
            if (c == 'D' || c == 'J') {
                // double和long占用2个栈单元
                typeCount += 2;
            } else if (c != '[') {
                // 其他类型占用1个栈单元
                // 数组维度标记'['不计入
                typeCount += 1;
                // 对象类型需要跳过类名
                if (c == 'L') {
                    i = desc.indexOf(';', i);
                }
            }
        }
        
        // 从栈中弹出对应数量的元素
        if (typeCount > 0) {
            currentStackSize -= typeCount;
        }
    }
}