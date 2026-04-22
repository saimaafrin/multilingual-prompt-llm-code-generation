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

        // 返回下一个要写入该帧的元素的索引
        return currentFrame.getNextIndex();
    }

    // Frame类定义
    public static class Frame {
        private int offset;
        private int numLocal;
        private int numStack;
        private int nextIndex;

        public Frame() {
            this.nextIndex = 0;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public void setNumLocal(int numLocal) {
            this.numLocal = numLocal;
        }

        public void setNumStack(int numStack) {
            this.numStack = numStack;
        }

        public int getNextIndex() {
            return nextIndex++;
        }
    }
}