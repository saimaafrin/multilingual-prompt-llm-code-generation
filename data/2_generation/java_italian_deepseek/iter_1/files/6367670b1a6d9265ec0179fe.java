import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        write(b, 0, b.length);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Invalid offset or length");
        }
        for (int i = 0; i < len; i++) {
            write(b[off + i]);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Implementazione specifica per scrivere un singolo byte
        // Ad esempio, potrebbe scrivere su un file, una socket, ecc.
        // Questo è un esempio di implementazione di base che non fa nulla.
        // Sostituisci con la logica appropriata.
    }
}