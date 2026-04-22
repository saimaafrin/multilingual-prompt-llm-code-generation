public class FrameVisitor {
    private int[] currentFrame;
    private int currentIndex;

    public FrameVisitor() {
        this.currentFrame = new int[0];
        this.currentIndex = 0;
    }

    /**
     * 开始访问一个新的栈映射帧，该帧存储在 {@link #currentFrame} 中。
     * @param offset   与该帧对应的指令的字节码偏移量。
     * @param numLocal 当前帧中的局部变量数量。
     * @param numStack 当前帧中的栈元素数量。
     * @return 下一个要写入该帧的元素的索引。
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // 计算新帧的大小
        int frameSize = numLocal + numStack;
        currentFrame = new int[frameSize];
        currentIndex = 0;

        // 返回下一个要写入的索引
        return currentIndex;
    }

    // 其他方法可以继续访问和操作 currentFrame
}