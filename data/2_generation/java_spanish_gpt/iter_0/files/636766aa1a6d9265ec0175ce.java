public class StackMapFrameVisitor {
    private StackMapFrame currentFrame;
    private int nextIndex;

    public StackMapFrameVisitor() {
        this.currentFrame = new StackMapFrame();
        this.nextIndex = 0;
    }

    /**
     * Inicia la visita de un nuevo "stack map frame", almacenado en {@link #currentFrame}.
     * @param offset   el desplazamiento de bytecode de la instrucción a la que corresponde el "frame".
     * @param numLocal el número de variables locales en el "frame".
     * @param numStack el número de elementos apilados en el "frame".
     * @return el índice del siguiente elemento que se escribirá en este "frame".
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        currentFrame.setOffset(offset);
        currentFrame.setNumLocal(numLocal);
        currentFrame.setNumStack(numStack);
        nextIndex = 0; // Reset the index for the new frame
        return nextIndex;
    }

    private class StackMapFrame {
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
    }
}