import java.util.Stack;

public class Frame {
    private Stack<Object> outputStack;

    public Frame() {
        this.outputStack = new Stack<>();
    }

    /**
     * Rimuove il numero specificato di tipi astratti dallo stack del frame di output.
     * @param elements il numero di tipi astratti che devono essere rimossi.
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Il numero di elementi da rimuovere non può essere negativo.");
        }
        if (outputStack.size() < elements) {
            throw new IllegalStateException("Non ci sono abbastanza elementi nello stack per rimuovere.");
        }
        for (int i = 0; i < elements; i++) {
            outputStack.pop();
        }
    }

    // Metodo di esempio per aggiungere elementi allo stack (per testing)
    public void push(Object element) {
        outputStack.push(element);
    }

    // Metodo di esempio per ottenere la dimensione dello stack (per testing)
    public int size() {
        return outputStack.size();
    }
}