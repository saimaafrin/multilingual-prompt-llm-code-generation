import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {

    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        
        for (int i = 0; i < b.length; i++) {
            write(b[i]);
        }
    }

    @Override
    public void write(int b) throws IOException {
        // Basic implementation required by OutputStream
        // Actual implementation would depend on specific output destination
    }
}