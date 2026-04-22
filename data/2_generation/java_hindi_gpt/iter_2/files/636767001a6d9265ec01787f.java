public class ArrayDetailAppender {

    /**
     * <p><code>toString</code> में <code>int</code> ऐरे का विवरण जोड़ें।</p>
     * @param buffer  वह <code>StringBuffer</code> जिसे भरना है
     * @param fieldName  फ़ील्ड का नाम, आमतौर पर उपयोग नहीं किया जाता क्योंकि पहले से ही जोड़ा गया है
     * @param array  वह ऐरे जिसे <code>toString</code> में जोड़ना है, <code>null</code> नहीं होना चाहिए
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
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
        ArrayDetailAppender appender = new ArrayDetailAppender();
        StringBuffer buffer = new StringBuffer();
        int[] array = {1, 2, 3, 4, 5};
        appender.appendDetail(buffer, "MyArray", array);
        System.out.println(buffer.toString());
    }
}