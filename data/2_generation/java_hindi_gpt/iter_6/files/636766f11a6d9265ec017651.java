public class ArrayUtil {

    private static final Character[] EMPTY_ARRAY = new Character[0];

    /** 
     * <p>एक रक्षात्मक प्रोग्रामिंग तकनीक जो <code>null</code> संदर्भ को एक खाली संदर्भ में बदलती है।</p> 
     * <p>यह विधि <code>null</code> इनपुट ऐरे के लिए एक खाली ऐरे लौटाती है।</p> 
     * <p>एक मेमोरी ऑप्टिमाइजिंग तकनीक के रूप में, एक खाली ऐरे जो पास किया गया है, इसे इस वर्ग में खाली <code>public static</code> संदर्भों के साथ ओवरराइड किया जाएगा।</p>
     * @param array  वह ऐरे जिसे <code>null</code> या खाली के लिए जांचना है
     * @return वही ऐरे, <code>public static</code> खाली ऐरे यदि <code>null</code> या खाली इनपुट हो
     * @since 2.5
     */
    public static Character[] nullToEmpty(final Character[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Character[] nullArray = null;
        Character[] emptyArray = {};
        Character[] filledArray = {'A', 'B', 'C'};

        System.out.println(nullToEmpty(nullArray).length); // Output: 0
        System.out.println(nullToEmpty(emptyArray).length); // Output: 0
        System.out.println(nullToEmpty(filledArray).length); // Output: 3
    }
}