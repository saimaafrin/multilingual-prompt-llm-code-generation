import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CustomByteArrayOutputStream extends ByteArrayOutputStream {

    /** 
     * Writes <code>len</code> bytes from the specified byte array starting at offset <code>off</code> to this byte array output stream.
     * @param b   the data.
     * @param off the start offset in the data.
     * @param len the number of bytes to write.
     */
    @Override 
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException();
        }
        if (len == 0) {
            return;
        }
        super.write(b, off, len);
    }

    public static void main(String[] args) {
        // Example usage
        CustomByteArrayOutputStream baos = new CustomByteArrayOutputStream();
        byte[] data = {1, 2, 3, 4, 5};
        try {
            baos.write(data, 1, 3); // Writes bytes 2, 3, 4
            System.out.println("Written bytes: " + baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}