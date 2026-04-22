import java.util.Arrays;

public class ByteBuffer {
    private byte[] buffer;

    /**
     * Cerca un byte di valore specificato nel <code>buffer</code>, partendo dalla <code>posizione</code> specificata.
     * @param value Il valore da cercare.
     * @param pos   La posizione di partenza per la ricerca.
     * @return La posizione del byte trovato, contando dall'inizio del <code>buffer</code>, oppure <code>-1</code> se non trovato.
     */
    protected int findByte(byte value, int pos) {
        if (buffer == null || pos < 0 || pos >= buffer.length) {
            return -1;
        }

        for (int i = pos; i < buffer.length; i++) {
            if (buffer[i] == value) {
                return i;
            }
        }
        
        return -1;
    }
}