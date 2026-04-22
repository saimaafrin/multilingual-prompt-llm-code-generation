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
            // Scrivi alcuni byte di esempio (puoi sostituire con i byte che vuoi copiare)
            outputStream.write(new byte[]{1, 2, 3, 4, 5});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        ByteArrayCopier copier = new ByteArrayCopier();
        byte[] byteArray = copier.toByteArray();
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }
    }
}