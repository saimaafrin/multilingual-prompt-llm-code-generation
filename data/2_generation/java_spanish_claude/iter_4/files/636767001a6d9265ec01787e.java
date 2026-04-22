public class StringBuilder {
    private char[] value;
    private int count;
    
    /**
     * <p> Obtiene la cadena construida por este constructor. </p>
     * @return la cadena construida
     */
    public String toString() {
        return new String(value, 0, count);
    }
}