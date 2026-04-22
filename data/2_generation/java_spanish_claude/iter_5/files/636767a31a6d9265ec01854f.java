import java.io.IOException;

public class FieldReader {
    private boolean isPackedField = false;
    private int currentPosition = 0;
    private byte[] buffer;
    private static final byte PACKED_FIELD_MARKER = 0x1C;
    
    /**
     * Verifica si este campo ha sido empaquetado en un campo delimitado por longitud. 
     * Si es así, actualiza el estado interno para reflejar que se están leyendo campos empaquetados.
     * @throws IOException si hay un error al leer el buffer
     */
    private void checkIfPackedField() throws IOException {
        if (currentPosition >= buffer.length) {
            throw new IOException("Buffer overflow - unable to check for packed field");
        }
        
        // Verifica si el byte actual es el marcador de campo empaquetado
        if (buffer[currentPosition] == PACKED_FIELD_MARKER) {
            isPackedField = true;
            currentPosition++; // Avanza la posición para saltar el marcador
        } else {
            isPackedField = false;
        }
    }
}