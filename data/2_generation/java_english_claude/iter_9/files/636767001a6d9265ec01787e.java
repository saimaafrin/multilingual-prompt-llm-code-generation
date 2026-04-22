public class StringBuilder {
    private char[] value;
    private int count;
    
    /**
     * <p> Gets the String built by this builder. </p>
     * @return the built string
     */
    public String toString() {
        return new String(value, 0, count);
    }
}