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
            decoder.decode(slice).get(0, chars, 0, 1);
            
            // Append decoded character
            sb.append(chars[0]);
            
            // Reset to marked position and skip decoded bytes
            bb.reset();
            int bytesRead = slice.position();
            bb.position(bb.position() + bytesRead);
            
            return i + bytesRead;
            
        } catch (CharacterCodingException e) {
            // On error, skip one byte and append replacement character
            bb.get();
            sb.append('\uFFFD');
            return i + 1;
        }
    }
}