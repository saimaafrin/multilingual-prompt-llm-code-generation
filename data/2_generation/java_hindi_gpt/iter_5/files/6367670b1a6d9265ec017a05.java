public class CharUtils {
    private static final String[] cache = new String[128];

    static {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = String.valueOf((char) i);
        }
    }

    /**
     * <p>एक वर्ण को एक स्ट्रिंग में परिवर्तित करता है जिसमें केवल वही वर्ण होता है।</p> 
     * <p>ASCII 7 बिट वर्णों के लिए, यह एक कैश का उपयोग करता है जो हर बार वही स्ट्रिंग ऑब्जेक्ट लौटाता है।</p> 
     * <pre> CharUtils.toString(' ')  = " " CharUtils.toString('A')  = "A" </pre>
     * @param ch  वह वर्ण जिसे परिवर्तित करना है
     * @return एक स्ट्रिंग जो निर्दिष्ट वर्ण को समाहित करती है
     */
    public static String toString(final char ch) {
        if (ch >= 0 && ch < 128) {
            return cache[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(CharUtils.toString(' ')); // Output: " "
        System.out.println(CharUtils.toString('A')); // Output: "A"
        System.out.println(CharUtils.toString('Z')); // Output: "Z"
        System.out.println(CharUtils.toString('ñ')); // Output: "ñ"
    }
}