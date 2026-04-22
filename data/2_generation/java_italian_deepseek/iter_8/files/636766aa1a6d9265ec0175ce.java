public class FrameVisitor {
    private Frame currentFrame;

    public FrameVisitor(Frame currentFrame) {
        this.currentFrame = currentFrame;
    }

    /**
     * Inizia la visita di un nuovo frame della mappa dello stack, memorizzato in {@link #currentFrame}.
     * @param offset   l'offset del bytecode dell'istruzione a cui corrisponde il frame.
     * @param numLocal il numero di variabili locali nel frame.
     * @param numStack il numero di elementi nello stack nel frame.
     * @return l'indice del prossimo elemento da scrivere in questo frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Inizializza il nuovo frame con i parametri forniti
        currentFrame = new Frame(offset, numLocal, numStack);

        // Restituisce l'indice del prossimo elemento da scrivere nel frame
        return currentFrame.getNextWriteIndex();
    }

    // Classe interna per rappresentare un frame
    private static class Frame {
        private final int offset;
        private final int numLocal;
        private final int numStack;
        private int nextWriteIndex;

        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.nextWriteIndex = 0; // Inizia a scrivere dal primo elemento
        }

        public int getNextWriteIndex() {
            return nextWriteIndex;
        }

        // Altri metodi per gestire il frame...
    }
}