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
            } else if (c == '[') {
                // 数组类型,跳过'['字符
                while (desc.charAt(i) == '[') {
                    i++;
                }
                if (desc.charAt(i) == 'L') {
                    // 对象数组,跳到';'
                    i = desc.indexOf(';', i);
                }
                typeCount++;
            } else if (c == 'L') {
                // 对象类型,跳到';'
                i = desc.indexOf(';', i);
                typeCount++;
            } else {
                // 基本类型
                typeCount++;
            }
        }
        
        // 从栈中弹出计算出的类型数量
        currentStackSize -= typeCount;
    }
}