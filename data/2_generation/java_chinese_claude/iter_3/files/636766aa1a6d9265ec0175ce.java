import org.objectweb.asm.Label;

public class StackMapFrameVisitor {
    private int[] currentFrame;
    private int currentFrameIndex;
    
    /**
     * 开始访问一个新的栈映射帧，该帧存储在 {@link #currentFrame} 中。
     * @param offset   与该帧对应的指令的字节码偏移量。
     * @param numLocal 当前帧中的局部变量数量。
     * @param numStack 当前帧中的栈元素数量。
     * @return 下一个要写入该帧的元素的索引。
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // 计算帧大小 = 偏移量(1) + 局部变量数量(1) + 栈元素数量(1) + 实际元素数量
        int frameSize = 3 + numLocal + numStack;
        
        // 初始化或扩展currentFrame数组
        if (currentFrame == null || currentFrame.length < frameSize) {
            currentFrame = new int[frameSize];
        }
        
        // 存储帧信息
        currentFrame[0] = offset;
        currentFrame[1] = numLocal;
        currentFrame[2] = numStack;
        
        // 重置当前索引到局部变量区域开始处
        currentFrameIndex = 3;
        
        return currentFrameIndex;
    }
}