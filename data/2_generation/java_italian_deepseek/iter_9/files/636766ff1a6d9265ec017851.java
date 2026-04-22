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
            throw new IndexOutOfBoundsException("Posizione di partenza non valida.");
        }

        for (int i = pos; i < buffer.limit(); i++) {
            if (buffer.get(i) == value) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        ByteSearcher searcher = new ByteSearcher(buffer);

        int position = searcher.findByte((byte) 5, 2);
        System.out.println("Byte trovato alla posizione: " + position);
    }
}