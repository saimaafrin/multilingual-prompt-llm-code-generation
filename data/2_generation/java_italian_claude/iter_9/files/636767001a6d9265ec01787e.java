public class StringBuilder {
    private char[] value;
    private int count;
    
    /**
     * <p> Ottiene la String costruita da questo builder. </p>
     * @return la stringa costruita
     */
    public String toString() {
        return new String(value, 0, count);
    }
}