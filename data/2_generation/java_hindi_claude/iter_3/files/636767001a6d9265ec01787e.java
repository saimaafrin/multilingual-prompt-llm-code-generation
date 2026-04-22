public class StringBuilder {
    private char[] value;
    private int count;
    
    public String toString() {
        // Create a new String using the internal char array
        return new String(value, 0, count);
    }
}