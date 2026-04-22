import java.io.IOException;

@Override
public void write(byte b[]) throws IOException {
    if (b == null) {
        throw new NullPointerException("Byte array cannot be null");
    }
    for (byte value : b) {
        write(value);
    }
}