import java.io.IOException;
import java.io.InputStream;

public class TagReader {
    private InputStream inputStream;

    public TagReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Tentativo di leggere un tag di campo, restituendo zero se abbiamo raggiunto la fine del file (EOF).
     * I parser di messaggi di protocollo utilizzano questo metodo per leggere i tag, poiché un messaggio di protocollo
     * può legalmente terminare ovunque si trovi un tag, e zero non è un numero di tag valido.
     *
     * @return il tag letto, o 0 se è stato raggiunto EOF
     * @throws IOException se si verifica un errore di I/O durante la lettura
     */
    public int readTag() throws IOException {
        int tag = inputStream.read();
        return tag == -1 ? 0 : tag;
    }
}