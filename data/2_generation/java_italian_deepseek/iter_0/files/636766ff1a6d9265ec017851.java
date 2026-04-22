import java.nio.ByteBuffer;

public class ByteSearcher {

    protected ByteBuffer buffer;

    public ByteSearcher(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Cerca un byte di valore specificato nel <code>buffer</code>, partendo dalla <code>posizione</code> specificata.
     * @param value Il valore da cercare.
     * @param pos   La posizione di partenza per la ricerca.
     * @return La posizione del byte trovato, contando dall'inizio del <code>buffer</code>, oppure <code>-1</code> se non trovato.
     */
    protected int findByte(byte value, int pos) {
        if (pos < 0 || pos >= buffer.limit()) {
            throw new IllegalArgumentException("Posizione di partenza non valida.");
        }

        for (int i = pos; i < buffer.limit(); i++) {
            if (buffer.get(i) == value) {
                return i;
            }
        }

        return -1;
    }
}