import java.util.Arrays;

/**
 * Copia i byte in un {@code byte[]}.
 */
public byte[] toByteArray() {
    // Assuming this method is part of a class that has a byte array field named 'data'
    // If not, replace 'data' with the appropriate field or logic to get the byte array
    if (this.data == null) {
        return new byte[0];
    }
    return Arrays.copyOf(this.data, this.data.length);
}