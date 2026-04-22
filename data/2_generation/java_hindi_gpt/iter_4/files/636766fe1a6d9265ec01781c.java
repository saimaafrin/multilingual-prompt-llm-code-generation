public class CharUtils {
    private static final Character[] cache = new Character[128];

    static {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = (char) i;
        }
    }

    /**
     * <p>चरित्र को एक Character में परिवर्तित करता है।</p> 
     * <p>ASCII 7 बिट चरित्रों के लिए, यह एक कैश का उपयोग करता है जो हर बार वही Character ऑब्जेक्ट लौटाता है。</p> 
     * <pre> CharUtils.toCharacterObject(' ')  = ' ' CharUtils.toCharacterObject('A')  = 'A' </pre>
     * @param ch  वह चरित्र जिसे परिवर्तित करना है
     * @return निर्दिष्ट चरित्र का एक Character
     */
    public static Character toCharacterObject(final char ch) {
        if (ch >= 0 && ch < 128) {
            return cache[ch];
        }
        return new Character(ch);
    }

    public static void main(String[] args) {
        System.out.println(toCharacterObject(' ')); // Output: ' '
        System.out.println(toCharacterObject('A')); // Output: 'A'
        System.out.println(toCharacterObject('ñ')); // Output: 'ñ'
    }
}