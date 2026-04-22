public class StringBuilderExample {
    
    private StringBuilder stringBuilder;

    public StringBuilderExample() {
        stringBuilder = new StringBuilder();
    }

    public void append(String str) {
        stringBuilder.append(str);
    }

    /** 
     * <p> इस बिल्डर द्वारा निर्मित स्ट्रिंग प्राप्त करता है। </p>
     * @return निर्मित स्ट्रिंग
     */
    public String toString() {
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuilderExample example = new StringBuilderExample();
        example.append("Hello, ");
        example.append("World!");
        System.out.println(example.toString()); // Output: Hello, World!
    }
}