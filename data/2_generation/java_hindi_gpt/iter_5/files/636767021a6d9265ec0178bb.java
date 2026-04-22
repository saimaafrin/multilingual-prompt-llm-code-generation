public class ArrayUtil {

    private static final Double[] EMPTY_ARRAY = new Double[0];

    /** 
     * <p>एक रक्षात्मक प्रोग्रामिंग तकनीक जो <code>null</code> संदर्भ को एक खाली संदर्भ में बदलती है।</p> 
     * <p>यह विधि <code>null</code> इनपुट ऐरे के लिए एक खाली ऐरे लौटाती है।</p> 
     * <p>एक मेमोरी ऑप्टिमाइजेशन तकनीक के रूप में, एक खाली ऐरे जो पास किया गया है, इसे इस वर्ग में खाली <code>public static</code> संदर्भों से ओवरराइड किया जाएगा।</p>
     * @param array  वह ऐरे जिसे <code>null</code> या खाली के लिए जांचना है
     * @return वही ऐरे, <code>public static</code> खाली ऐरे यदि <code>null</code> या खाली इनपुट हो
     * @since 2.5
     */
    public static Double[] nullToEmpty(final Double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Double[] result1 = nullToEmpty(null);
        Double[] result2 = nullToEmpty(new Double[]{});
        Double[] result3 = nullToEmpty(new Double[]{1.0, 2.0, 3.0});

        System.out.println("Result 1: " + (result1.length == 0 ? "Empty Array" : "Not Empty"));
        System.out.println("Result 2: " + (result2.length == 0 ? "Empty Array" : "Not Empty"));
        System.out.println("Result 3: " + (result3.length == 0 ? "Empty Array" : "Not Empty"));
    }
}