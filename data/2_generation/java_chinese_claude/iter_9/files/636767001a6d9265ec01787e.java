public class StringBuilder {
    private char[] value;
    private int count;
    
    /**
     * <p> 获取由此构建器构建的字符串。 </p>
     * @return 构建的字符串
     */
    public String toString() {
        // Create a new String containing the characters in the character array
        return new String(value, 0, count);
    }
}