public class ArrayUtil {

    private static final Byte[] EMPTY_BYTE_ARRAY = new Byte[0];

    /** 
     * <p>एक रक्षात्मक प्रोग्रामिंग तकनीक जो <code>null</code> संदर्भ को एक खाली संदर्भ में बदलती है।</p> 
     * <p>यह विधि <code>null</code> इनपुट ऐरे के लिए एक खाली ऐरे लौटाती है।</p> 
     * <p>एक मेमोरी ऑप्टिमाइजेशन तकनीक के रूप में, एक खाली ऐरे जो पास किया गया है, इसे इस वर्ग में खाली <code>public static</code> संदर्भों के साथ ओवरराइड किया जाएगा।</p>
     * @param array  वह ऐरे जिसे <code>null</code> या खाली के लिए जांचना है
     * @return वही ऐरे, <code>public static</code> खाली ऐरे यदि <code>null</code> या खाली इनपुट हो
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Byte[] nullArray = null;
        Byte[] emptyArray = new Byte[0];
        Byte[] nonEmptyArray = {1, 2, 3};

        System.out.println(nullToEmpty(nullArray)); // Should print: []
        System.out.println(nullToEmpty(emptyArray)); // Should print: []
        System.out.println(nullToEmpty(nonEmptyArray)); // Should print: [1, 2, 3]
    }
}