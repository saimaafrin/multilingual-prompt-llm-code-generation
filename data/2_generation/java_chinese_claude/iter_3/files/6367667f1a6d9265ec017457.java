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
            
            // Create a new byte buffer for the current character
            ByteBuffer slice = bb.slice();
            
            // Try to decode one character
            char[] chars = new char[1];
            java.nio.CharBuffer cb = java.nio.CharBuffer.wrap(chars);
            
            decoder.decode(slice, cb, true);
            decoder.flush(cb);
            
            // Append decoded character
            sb.append(chars[0]);
            
            // Calculate how many bytes were consumed
            int bytesConsumed = slice.position();
            
            // Reset to marked position and skip consumed bytes
            bb.reset();
            bb.position(bb.position() + bytesConsumed);
            
            return i + bytesConsumed;
            
        } catch (CharacterCodingException e) {
            // On error, skip one byte and append replacement character
            bb.get();
            sb.append('\ufffd');
            return i + 1;
        }
    }
}