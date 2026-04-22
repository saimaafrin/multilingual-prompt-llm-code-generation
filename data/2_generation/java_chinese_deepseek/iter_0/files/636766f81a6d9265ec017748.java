import java.util.Base64;

public class Base64Decoder {
    /**
     * 按照 Base64 规则解码字符串。
     * @param s 需要解码的 Base64 字符串
     * @return 解码后的字符串
     */
    public static String base64Decode(final String s) {
        byte[] decodedBytes = Base64.getDecoder().decode(s);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        String encodedString = "SGVsbG8gV29ybGQh"; // Example Base64 encoded string
        String decodedString = base64Decode(encodedString);
        System.out.println(decodedString); // Output: Hello World!
    }
}