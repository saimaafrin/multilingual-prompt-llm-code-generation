import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

private static int decodeOctets(int i, ByteBuffer bb, StringBuilder sb) {
    // Ottieni il byte corrente
    byte b = bb.get(i);
    
    // Determina il numero di byte necessari per rappresentare il carattere UTF-8
    int numBytes;
    if ((b & 0x80) == 0) {
        // 1 byte: 0xxxxxxx
        numBytes = 1;
    } else if ((b & 0xE0) == 0xC0) {
        // 2 byte: 110xxxxx
        numBytes = 2;
    } else if ((b & 0xF0) == 0xE0) {
        // 3 byte: 1110xxxx
        numBytes = 3;
    } else if ((b & 0xF8) == 0xF0) {
        // 4 byte: 11110xxx
        numBytes = 4;
    } else {
        // Byte non valido per UTF-8
        throw new IllegalArgumentException("Invalid UTF-8 sequence");
    }

    // Verifica che ci siano abbastanza byte rimanenti nel buffer
    if (i + numBytes > bb.limit()) {
        throw new IllegalArgumentException("Incomplete UTF-8 sequence");
    }

    // Crea un array per contenere i byte del carattere UTF-8
    byte[] utf8Bytes = new byte[numBytes];
    for (int j = 0; j < numBytes; j++) {
        utf8Bytes[j] = bb.get(i + j);
    }

    // Decodifica i byte in una stringa UTF-8
    String decodedChar = new String(utf8Bytes, StandardCharsets.UTF_8);

    // Aggiungi il carattere decodificato al StringBuilder
    sb.append(decodedChar);

    // Restituisci l'indice del prossimo carattere non controllato
    return i + numBytes;
}