public class FrameVisitor {
    private int currentFrame;
    private int nextIndex;

    /**
     * Inizia la visita di un nuovo frame della mappa dello stack, memorizzato in {@link #currentFrame}.
     * @param offset   l'offset del bytecode dell'istruzione a cui corrisponde il frame.
     * @param numLocal il numero di variabili locali nel frame.
     * @param numStack il numero di elementi nello stack nel frame.
     * @return l'indice del prossimo elemento da scrivere in questo frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Logica per iniziare la visita del frame
        currentFrame = offset; // memorizza l'offset nel frame corrente
        nextIndex = 0; // inizializza l'indice successivo a zero

        // Potresti voler gestire numLocal e numStack qui, ad esempio:
        // Allocare spazio per le variabili locali e lo stack, se necessario

        return nextIndex; // restituisce l'indice del prossimo elemento da scrivere
    }

    public static void main(String[] args) {
        FrameVisitor visitor = new FrameVisitor();
        int nextElementIndex = visitor.visitFrameStart(10, 5, 3);
        System.out.println("Next element index: " + nextElementIndex);
    }
}