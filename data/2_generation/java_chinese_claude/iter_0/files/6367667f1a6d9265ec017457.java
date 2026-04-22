import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

public class UTF8Decoder {

    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        try {
            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE);

            // Mark current position
            bb.mark();
            
            // Create temporary buffer for decoding
            ByteBuffer temp = ByteBuffer.allocate(4);
            
            // Read up to 4 bytes for UTF-8 character
            int count = 0;
            while (count < 4 && bb.hasRemaining()) {
                byte b = bb.get();
                temp.put(b);
                count++;
                
                // Check if we have a complete UTF-8 character
                if ((b & 0xC0) != 0x80) {
                    break;
                }
            }
            
            temp.flip();
            
            // Decode bytes to characters
            CharBuffer charBuffer = decoder.decode(temp);
            sb.append(charBuffer);
            
            // Reset position to marked position
            bb.reset();
            
            // Advance position by number of bytes read
            bb.position(bb.position() + count);
            
            return i + count;
            
        } catch (CharacterCodingException e) {
            // On error, skip one byte and append replacement character
            bb.position(bb.position() + 1);
            sb.append('\uFFFD');
            return i + 1;
        }
    }
}