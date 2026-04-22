public class FrameVisitor {
    private int[] currentFrame;
    private int currentIndex;

    /**
     * 开始访问一个新的栈映射帧，该帧存储在 {@link #currentFrame} 中。
     * @param offset   与该帧对应的指令的字节码偏移量。
     * @param numLocal 当前帧中的局部变量数量。
     * @param numStack 当前帧中的栈元素数量。
     * @return 下一个要写入该帧的元素的索引。
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Initialize the current frame with the size of local variables and stack
        currentFrame = new int[numLocal + numStack];
        currentIndex = 0;

        // Here you can add logic to handle the offset if needed

        // Return the next index to write to
        return currentIndex;
    }
}