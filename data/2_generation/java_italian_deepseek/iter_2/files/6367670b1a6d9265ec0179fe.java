import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(int b) throws IOException {
        // Implementazione di base per scrivere un singolo byte
        // Questo metodo deve essere implementato per estendere OutputStream
    }

    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException("L'array di byte non può essere null");
        }
        write(b, 0, b.length);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("L'array di byte non può essere null");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Offset o lunghezza non validi");
        }
        for (int i = 0; i < len; i++) {
            write(b[off + i]);
        }
    }
}