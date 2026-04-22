public class CharUtils {
    /** 
     * <p>Character को char में परिवर्तित करता है और <code>null</code> को संभालता है।</p> 
     * <pre> 
     * CharUtils.toChar(null, 'X') = 'X' 
     * CharUtils.toChar(' ', 'X')  = ' ' 
     * CharUtils.toChar('A', 'X')  = 'A' 
     * </pre>
     * @param ch  वह चर जिसे परिवर्तित करना है
     * @param defaultValue  वह मान जिसका उपयोग किया जाएगा यदि Character null है
     * @return Character का char मान या null होने पर डिफ़ॉल्ट मान
     */
    public static char toChar(final Character ch, final char defaultValue) {
        return (ch != null) ? ch : defaultValue;
    }

    public static void main(String[] args) {
        System.out.println(toChar(null, 'X')); // Output: X
        System.out.println(toChar(' ', 'X'));  // Output:  
        System.out.println(toChar('A', 'X'));  // Output: A
    }
}