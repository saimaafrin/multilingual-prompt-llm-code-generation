import java.io.ByteArrayOutputStream;

public class ByteBuffer {
    private byte[] buffer;
    
    /**
     * Busca un byte de valor especificado en el <code>buffer</code>, comenzando en la <code>posición</code> especificada.
     * @param value El valor a encontrar.
     * @param pos   La posición inicial para la búsqueda.
     * @return La posición del byte encontrado, contando desde el inicio del <code>buffer</code>, o <code>-1</code> si no se encuentra.
     */
    protected int findByte(byte value, int pos) {
        if (buffer == null || pos < 0 || pos >= buffer.length) {
            return -1;
        }
        
        for (int i = pos; i < buffer.length; i++) {
            if (buffer[i] == value) {
                return i;
            }
        }
        
        return -1;
    }
}