public class StringSplitter {
    public static String[] split(String toSplit, String delimiter) {
        if (toSplit == null || delimiter == null) {
            return null;
        }
        
        int delimiterIndex = toSplit.indexOf(delimiter);
        if (delimiterIndex == -1) {
            return null;
        }
        
        String beforeDelimiter = toSplit.substring(0, delimiterIndex);
        String afterDelimiter = toSplit.substring(delimiterIndex + delimiter.length());
        
        return new String[] { beforeDelimiter, afterDelimiter };
    }

    public static void main(String[] args) {
        String[] result = split("Hello,World", ",");
        if (result != null) {
            System.out.println("Before: " + result[0]);
            System.out.println("After: " + result[1]);
        } else {
            System.out.println("Delimiter not found.");
        }
    }
}