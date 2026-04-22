public class FrameVisitor {
    private Frame currentFrame;

    /**
     * Inizia la visita di un nuovo frame della mappa dello stack, memorizzato in {@link #currentFrame}.
     * @param offset   l'offset del bytecode dell'istruzione a cui corrisponde il frame.
     * @param numLocal il numero di variabili locali nel frame.
     * @param numStack il numero di elementi nello stack nel frame.
     * @return l'indice del prossimo elemento da scrivere in questo frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        currentFrame = new Frame(offset, numLocal, numStack);
        return currentFrame.getNextIndex();
    }

    private static class Frame {
        private final int offset;
        private final int numLocal;
        private final int numStack;
        private int nextIndex;

        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.nextIndex = 0; // Inizializza l'indice del prossimo elemento da scrivere
        }

        public int getNextIndex() {
            return nextIndex++;
        }
    }
}