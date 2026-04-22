import java.util.Stack;

public class FrameStack {
    private Stack<Object> outputFrameStack;

    public FrameStack() {
        this.outputFrameStack = new Stack<>();
    }

    /** 
     * Rimuove il numero specificato di tipi astratti dallo stack del frame di output.
     * @param elements il numero di tipi astratti che devono essere rimossi.
     */
    private void pop(final int elements) {
        if (elements < 0) {
            throw new IllegalArgumentException("Il numero di elementi da rimuovere non può essere negativo.");
        }
        if (elements > outputFrameStack.size()) {
            throw new IllegalArgumentException("Il numero di elementi da rimuovere è maggiore della dimensione dello stack.");
        }
        for (int i = 0; i < elements; i++) {
            outputFrameStack.pop();
        }
    }

    // Metodo di esempio per aggiungere elementi allo stack
    public void push(Object element) {
        outputFrameStack.push(element);
    }

    // Metodo di esempio per ottenere la dimensione dello stack
    public int size() {
        return outputFrameStack.size();
    }
}