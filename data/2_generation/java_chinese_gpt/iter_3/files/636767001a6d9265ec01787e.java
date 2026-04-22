public class StringBuilderExample {
    
    private StringBuilder builder;

    public StringBuilderExample() {
        this.builder = new StringBuilder();
    }

    public void append(String str) {
        builder.append(str);
    }

    /** 
     * <p> 获取由此构建器构建的字符串。 </p>
     * @return 构建的字符串
     */
    public String toString() {
        return builder.toString();
    }

    public static void main(String[] args) {
        StringBuilderExample example = new StringBuilderExample();
        example.append("Hello, ");
        example.append("World!");
        System.out.println(example.toString()); // Output: Hello, World!
    }
}