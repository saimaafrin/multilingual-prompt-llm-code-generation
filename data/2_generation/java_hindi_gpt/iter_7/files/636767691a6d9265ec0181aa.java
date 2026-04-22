import java.util.Arrays;

public class HashCodeUtil {
    /** 
     * निर्दिष्ट एरे की सामग्री के आधार पर एक हैश कोड लौटाता है। यदि <code>array</code> <code>null</code> है, तो यह विधि 0 लौटाती है।
     * @param array वह लॉन्ग एरे जिससे हैशकोड प्राप्त करना है
     * @return लॉन्ग एरे का हैशकोड, जो कि 0 हो सकता है यदि एरे null है।
     */
    public static int nullSafeHashCode(long[] array) {
        if (array == null) {
            return 0;
        }
        return Arrays.hashCode(array);
    }

    public static void main(String[] args) {
        long[] array1 = {1L, 2L, 3L};
        long[] array2 = null;

        System.out.println(nullSafeHashCode(array1)); // Output: hash code of array1
        System.out.println(nullSafeHashCode(array2)); // Output: 0
    }
}