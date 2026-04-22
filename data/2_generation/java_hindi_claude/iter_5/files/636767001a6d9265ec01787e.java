public class StringBuilder {
    private char[] buffer;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public StringBuilder() {
        buffer = new char[DEFAULT_CAPACITY];
        size = 0;
    }

    public String toString() {
        return new String(buffer, 0, size);
    }
}