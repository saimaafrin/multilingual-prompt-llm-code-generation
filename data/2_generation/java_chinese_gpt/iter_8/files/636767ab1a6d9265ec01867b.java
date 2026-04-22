import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

class WriteSession {
    // Assuming WriteSession has some properties and methods
}

class LinkedBuffer {
    private LinkedList<byte[]> buffers = new LinkedList<>();

    public void write(byte[] data) {
        buffers.add(data);
    }

    public LinkedList<byte[]> getBuffers() {
        return buffers;
    }
}

public class UTF8Writer {
    /** 
     * 将字符串中的 UTF-8 编码字节写入 {@link LinkedBuffer}。
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            throw new IllegalArgumentException("Input string and LinkedBuffer cannot be null");
        }
        
        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        lb.write(utf8Bytes);
        
        return lb;
    }

    public static void main(String[] args) {
        WriteSession session = new WriteSession();
        LinkedBuffer lb = new LinkedBuffer();
        String testString = "Hello, UTF-8!";
        
        LinkedBuffer result = writeUTF8(testString, session, lb);
        for (byte[] buffer : result.getBuffers()) {
            System.out.println(new String(buffer, StandardCharsets.UTF_8));
        }
    }
}