import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class OctetDecoder {

    /** 
     * Decodes octets to characters using the UTF-8 decoding and appends the characters to a StringBuffer.
     * @return the index to the next unchecked character in the string to decode
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        while (i < bb.limit()) {
            // Read the next byte
            byte b = bb.get(i);
            // Check if the byte is a valid UTF-8 continuation byte
            if ((b & 0x80) == 0) {
                // Single byte character (ASCII)
                sb.append((char) b);
                i++;
            } else {
                // Start of a multi-byte character
                int charLength = 0;
                if ((b & 0xE0) == 0xC0) {
                    charLength = 2; // 110xxxxx
                } else if ((b & 0xF0) == 0xE0) {
                    charLength = 3; // 1110xxxx
                } else if ((b & 0xF8) == 0xF0) {
                    charLength = 4; // 11110xxx
                } else {
                    // Invalid UTF-8 start byte
                    throw new IllegalArgumentException("Invalid UTF-8 byte sequence");
                }

                // Read the next bytes for the character
                byte[] bytes = new byte[charLength];
                bytes[0] = b;
                for (int j = 1; j < charLength; j++) {
                    if (i + j >= bb.limit()) {
                        throw new IllegalArgumentException("Unexpected end of byte buffer");
                    }
                    byte nextByte = bb.get(i + j);
                    if ((nextByte & 0xC0) != 0x80) {
                        throw new IllegalArgumentException("Invalid UTF-8 continuation byte");
                    }
                    bytes[j] = nextByte;
                }

                // Convert bytes to character and append to StringBuilder
                String decodedString = new String(bytes, StandardCharsets.UTF_8);
                sb.append(decodedString);
                i += charLength;
            }
        }
        return i;
    }
}