public class StringSplitter {
    public static String[] split(String toSplit, String delimiter) {
        if (toSplit == null || delimiter == null) {
            return null;
        }
        
        int index = toSplit.indexOf(delimiter);
        if (index == -1) {
            return null;
        }
        
        String[] result = new String[2];
        result[0] = toSplit.substring(0, index);
        result[1] = toSplit.substring(index + delimiter.length());
        
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        String[] result = split("Hello,World", ",");
        if (result != null) {
            System.out.println("Before delimiter: " + result[0]);
            System.out.println("After delimiter: " + result[1]);
        } else {
            System.out.println("Delimiter not found.");
        }
    }
}