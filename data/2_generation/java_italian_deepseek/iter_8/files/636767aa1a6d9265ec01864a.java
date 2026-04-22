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
            // Scrivi i byte nel ByteArrayOutputStream (esempio)
            outputStream.write(new byte[] { 0x01, 0x02, 0x03 });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static void main(String[] args) {
        ByteArrayCopier copier = new ByteArrayCopier();
        byte[] byteArray = copier.toByteArray();
        for (byte b : byteArray) {
            System.out.printf("%02X ", b);
        }
    }
}