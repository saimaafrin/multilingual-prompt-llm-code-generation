import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Decoder {

    /**
     * Decodifica gli ottetti in caratteri utilizzando la decodifica UTF-8 e aggiunge i caratteri ad uno oggetto StringBuffer.
     * @param i l'indice iniziale da cui iniziare la decodifica
     * @param bb il ByteBuffer contenente i dati da decodificare
     * @param sb il StringBuilder a cui aggiungere i caratteri decodificati
     * @return l'indice del prossimo carattere non controllato nella stringa da decodificare
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        int length = bb.remaining();
        byte[] bytes = new byte[length];
        bb.get(bytes);
        
        String decodedString = new String(bytes, i, length - i, StandardCharsets.UTF_8);
        sb.append(decodedString);
        
        return length; // Restituisce l'indice del prossimo carattere non controllato
    }
}