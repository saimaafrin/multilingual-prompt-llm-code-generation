import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class BufferToByteArray {

    private ByteArrayOutputStream buffer;

    public BufferToByteArray() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) {
        try {
            buffer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) {
        BufferToByteArray buffer = new BufferToByteArray();
        buffer.write(new byte[]{1, 2, 3});
        buffer.write(new byte[]{4, 5, 6});

        byte[] result = buffer.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}