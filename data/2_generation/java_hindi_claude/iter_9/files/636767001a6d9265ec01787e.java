public class StringBuilder {
    private char[] value;
    private int count;
    
    public String toString() {
        // Create new String from internal char array
        return new String(value, 0, count);
    }
}