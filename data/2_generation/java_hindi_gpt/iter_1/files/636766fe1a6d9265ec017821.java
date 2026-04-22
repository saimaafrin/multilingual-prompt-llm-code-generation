public class Example {

    /**
     * <p><code>toString</code> में <code>byte</code> ऐरे का विवरण जोड़ें।</p>
     * @param buffer  वह <code>StringBuffer</code> जिसे भरना है
     * @param fieldName  फ़ील्ड का नाम, आमतौर पर इसका उपयोग नहीं किया जाता क्योंकि यह पहले से ही जोड़ा गया है
     * @param array  वह ऐरे जिसे <code>toString</code> में जोड़ना है, <code>null</code> नहीं होना चाहिए
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        buffer.append(fieldName).append(": [");
        for (int i = 0; i < array.length; i++) {
            buffer.append(array[i]);
            if (i < array.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append("]");
    }

    public static void main(String[] args) {
        Example example = new Example();
        StringBuffer buffer = new StringBuffer();
        byte[] byteArray = {1, 2, 3, 4, 5};
        example.appendDetail(buffer, "byteArray", byteArray);
        System.out.println(buffer.toString());
    }
}