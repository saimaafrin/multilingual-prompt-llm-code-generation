public class StringBuilderExample {
    private StringBuilder builder;

    public StringBuilderExample() {
        this.builder = new StringBuilder();
    }

    public void append(String str) {
        builder.append(str);
    }

    /** 
     * <p> Gets the String built by this builder. </p>
     * @return the built string
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