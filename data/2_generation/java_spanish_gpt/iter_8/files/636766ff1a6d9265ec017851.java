public class ByteFinder {
    
    private byte[] buffer;

    public ByteFinder(byte[] buffer) {
        this.buffer = buffer;
    }

    /** 
     * Busca un byte de valor especificado en el <code>buffer</code>, comenzando en la <code>posición</code> especificada.
     * @param value El valor a encontrar.
     * @param pos   La posición inicial para la búsqueda.
     * @return La posición del byte encontrado, contando desde el inicio del <code>buffer</code>, o <code>-1</code> si no se encuentra.
     */
    protected int findByte(byte value, int pos) {
        if (pos < 0 || pos >= buffer.length) {
            return -1; // Posición fuera de los límites del buffer
        }
        
        for (int i = pos; i < buffer.length; i++) {
            if (buffer[i] == value) {
                return i; // Retorna la posición del byte encontrado
            }
        }
        
        return -1; // No se encontró el byte
    }

    public static void main(String[] args) {
        byte[] data = {1, 2, 3, 4, 5, 2};
        ByteFinder finder = new ByteFinder(data);
        int position = finder.findByte((byte) 2, 0);
        System.out.println("Byte encontrado en la posición: " + position);
    }
}