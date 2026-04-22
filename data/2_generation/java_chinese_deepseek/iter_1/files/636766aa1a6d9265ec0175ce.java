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
        // 初始化当前帧的局部变量和栈
        currentFrame.initializeLocals(numLocal);
        currentFrame.initializeStack(numStack);

        // 设置当前帧的字节码偏移量
        currentFrame.setOffset(offset);

        // 返回下一个要写入该帧的元素的索引
        return currentFrame.getNextIndex();
    }

    // 假设 Frame 类的定义如下
    public static class Frame {
        private int offset;
        private int[] locals;
        private int[] stack;
        private int nextIndex;

        public void initializeLocals(int numLocal) {
            this.locals = new int[numLocal];
        }

        public void initializeStack(int numStack) {
            this.stack = new int[numStack];
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getNextIndex() {
            return nextIndex;
        }

        public void setNextIndex(int nextIndex) {
            this.nextIndex = nextIndex;
        }
    }
}