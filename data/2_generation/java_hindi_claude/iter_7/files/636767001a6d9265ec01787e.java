public class StringBuilder {
    private char[] value;
    private int count;
    
    public String toString() {
        return new String(value, 0, count);
    }
}