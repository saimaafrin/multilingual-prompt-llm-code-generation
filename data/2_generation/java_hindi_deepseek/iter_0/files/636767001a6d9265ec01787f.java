import java.util.Arrays;

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
    buffer.append(Arrays.toString(array));
}