import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayCopier {

    /**
     * Copia i byte in un {@code byte[]}.
     *
     * @return un array di byte contenente una copia dei byte
     */
    public byte[] toByteArray() {
        // Esempio di implementazione: copia i byte da un ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            // Scrivi i byte che vuoi copiare nell'outputStream
            outputStream.write("Esempio di byte".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        ByteArrayCopier copier = new ByteArrayCopier();
        byte[] byteArray = copier.toByteArray();
        System.out.println(new String(byteArray)); // Stampa i byte come stringa
    }
}