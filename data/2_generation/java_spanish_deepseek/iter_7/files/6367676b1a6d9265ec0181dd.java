public class StringUtils {

    public static int countOccurrencesOf(String str, String sub) {
        if (str == null || sub == null || sub.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "ababababab";
        String sub = "ab";
        System.out.println(countOccurrencesOf(str, sub)); // Output: 5
    }
}