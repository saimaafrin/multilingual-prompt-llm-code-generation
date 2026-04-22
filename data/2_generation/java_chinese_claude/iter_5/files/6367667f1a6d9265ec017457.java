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
            
            // Create a slice from current position
            ByteBuffer slice = bb.slice();
            
            // Decode UTF-8 bytes
            java.nio.CharBuffer cb = decoder.decode(slice);
            
            // Append decoded characters to StringBuilder
            sb.append(cb);
            
            // Calculate number of bytes consumed
            int bytesConsumed = (int)(bb.position() - bb.mark());
            
            // Reset position to marked position
            bb.reset();
            
            // Skip the consumed bytes
            bb.position(bb.position() + bytesConsumed);
            
            // Return next index
            return i + bytesConsumed;
            
        } catch (CharacterCodingException e) {
            // On error, skip one byte and add replacement character
            bb.get();
            sb.append('\ufffd');
            return i + 1;
        }
    }
}