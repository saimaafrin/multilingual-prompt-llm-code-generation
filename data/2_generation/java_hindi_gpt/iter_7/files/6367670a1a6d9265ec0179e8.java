public class ArrayUtil {

    private static final Boolean[] EMPTY_BOOLEAN_ARRAY = new Boolean[0];

    /** 
     * <p>एक रक्षात्मक प्रोग्रामिंग तकनीक जो <code>null</code> संदर्भ को एक खाली संदर्भ में बदलती है।</p> 
     * <p>यह विधि <code>null</code> इनपुट ऐरे के लिए एक खाली ऐरे लौटाती है।</p> 
     * <p>एक मेमोरी ऑप्टिमाइजेशन तकनीक के रूप में, एक खाली ऐरे जो पास किया गया है, इसे इस वर्ग में मौजूद खाली <code>public static</code> संदर्भों से ओवरराइड किया जाएगा।</p>
     * @param array  वह ऐरे जिसे <code>null</code> या खाली के लिए जांचना है
     * @return वही ऐरे, <code>public static</code> खाली ऐरे यदि <code>null</code> या खाली इनपुट हो
     * @since 2.5
     */
    public static Boolean[] nullToEmpty(final Boolean[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Boolean[] result1 = nullToEmpty(null);
        Boolean[] result2 = nullToEmpty(new Boolean[]{});
        Boolean[] result3 = nullToEmpty(new Boolean[]{true, false});

        System.out.println("Result 1: " + (result1.length == 0)); // true
        System.out.println("Result 2: " + (result2.length == 0)); // true
        System.out.println("Result 3: " + java.util.Arrays.toString(result3)); // [true, false]
    }
}