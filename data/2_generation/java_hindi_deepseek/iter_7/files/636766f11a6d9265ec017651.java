import java.util.Objects;

public class ArrayUtils {

    // Public static empty array reference
    public static final Character[] EMPTY_CHARACTER_ARRAY = new Character[0];

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
            return EMPTY_CHARACTER_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Character[] array1 = null;
        Character[] array2 = new Character[0];
        Character[] array3 = new Character[]{'a', 'b', 'c'};

        System.out.println(Objects.toString(nullToEmpty(array1))); // []
        System.out.println(Objects.toString(nullToEmpty(array2))); // []
        System.out.println(Objects.toString(nullToEmpty(array3))); // [a, b, c]
    }
}