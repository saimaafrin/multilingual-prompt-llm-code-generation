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
            
            // Try to decode remaining bytes
            while (bb.hasRemaining()) {
                try {
                    char[] chars = decoder.decode(bb).toString().toCharArray();
                    sb.append(chars);
                    return i + bb.position() - bb.markValue();
                } catch (CharacterCodingException e) {
                    // Reset to marked position if decode fails
                    bb.reset();
                    // Move forward one byte and try again
                    bb.get();
                    sb.append('?');
                    i++;
                }
            }
            
            return i;
            
        } catch (Exception e) {
            // In case of any other errors, append replacement char and return next position
            sb.append('?');
            return i + 1;
        }
    }
}