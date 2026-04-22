public class FrameVisitor {
    private Frame currentFrame;

    public FrameVisitor(Frame currentFrame) {
        this.currentFrame = currentFrame;
    }

    /**
     * 开始访问一个新的栈映射帧，该帧存储在 {@link #currentFrame} 中。
     * @param offset   与该帧对应的指令的字节码偏移量。
     * @param numLocal 当前帧中的局部变量数量。
     * @param numStack 当前帧中的栈元素数量。
     * @return 下一个要写入该帧的元素的索引。
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // 初始化当前帧的偏移量、局部变量数量和栈元素数量
        currentFrame.setOffset(offset);
        currentFrame.setNumLocal(numLocal);
        currentFrame.setNumStack(numStack);

        // 计算并返回下一个要写入该帧的元素的索引
        return numLocal + numStack;
    }

    // Frame类定义
    public static class Frame {
        private int offset;
        private int numLocal;
        private int numStack;

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public void setNumLocal(int numLocal) {
            this.numLocal = numLocal;
        }

        public void setNumStack(int numStack) {
            this.numStack = numStack;
        }

        public int getOffset() {
            return offset;
        }

        public int getNumLocal() {
            return numLocal;
        }

        public int getNumStack() {
            return numStack;
        }
    }
}