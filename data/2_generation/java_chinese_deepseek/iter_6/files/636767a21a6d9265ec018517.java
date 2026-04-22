import java.io.ByteArrayOutputStream;

public final class Buffer {
    private ByteArrayOutputStream buffer;

    public Buffer() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) {
        buffer.write(data, 0, data.length);
    }

    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.write(new byte[]{1, 2, 3, 4, 5});
        byte[] result = buffer.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}