import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Decoder {

    /**
     * Decodifica gli ottetti in caratteri utilizzando la decodifica UTF-8 e aggiunge i caratteri ad uno oggetto StringBuffer.
     * @param i l'indice corrente nella stringa da decodificare
     * @param bb il ByteBuffer contenente i dati da decodificare
     * @param sb il StringBuilder a cui aggiungere i caratteri decodificati
     * @return l'indice del prossimo carattere non controllato nella stringa da decodificare
     */
    private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
        // Ottieni il byte corrente
        byte b = bb.get(i);
        
        // Determina il numero di byte necessari per rappresentare il carattere UTF-8
        int numBytes;
        if ((b & 0x80) == 0) {
            numBytes = 1; // Carattere ASCII (1 byte)
        } else if ((b & 0xE0) == 0xC0) {
            numBytes = 2; // Carattere UTF-8 (2 byte)
        } else if ((b & 0xF0) == 0xE0) {
            numBytes = 3; // Carattere UTF-8 (3 byte)
        } else if ((b & 0xF8) == 0xF0) {
            numBytes = 4; // Carattere UTF-8 (4 byte)
        } else {
            throw new IllegalArgumentException("Byte non valido per la codifica UTF-8");
        }

        // Verifica che ci siano abbastanza byte nel buffer
        if (i + numBytes > bb.limit()) {
            throw new IllegalArgumentException("Byte insufficienti per la decodifica UTF-8");
        }

        // Crea un array per contenere i byte del carattere
        byte[] charBytes = new byte[numBytes];
        for (int j = 0; j < numBytes; j++) {
            charBytes[j] = bb.get(i + j);
        }

        // Decodifica i byte in una stringa UTF-8
        String decodedChar = new String(charBytes, StandardCharsets.UTF_8);

        // Aggiungi il carattere decodificato al StringBuilder
        sb.append(decodedChar);

        // Restituisci l'indice del prossimo carattere non controllato
        return i + numBytes;
    }
}