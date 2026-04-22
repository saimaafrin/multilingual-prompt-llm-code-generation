import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class URIMatcher {

    /**
     * एक URI को पैटर्न के खिलाफ मिलाएं।
     * @param uri वह URI जिसे टेम्पलेट के खिलाफ मिलाना है।
     * @return मिलान का परिणाम, अन्यथा यदि कोई मिलान नहीं होता है तो null।
     */
    public static MatchResult match(CharSequence uri) {
        // Define a regex pattern to match URIs
        String regex = "^(https?|ftp):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s?]*)(\\?([^#\\s]*))?(#(\\w*))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(uri);

        // Check if the URI matches the pattern
        if (matcher.matches()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        CharSequence uri = "https://www.example.com/path?query=123#fragment";
        MatchResult result = match(uri);

        if (result != null) {
            System.out.println("Match found!");
            System.out.println("Full URI: " + result.group(0));
            System.out.println("Protocol: " + result.group(1));
            System.out.println("Host: " + result.group(2));
            System.out.println("Path: " + result.group(5));
            System.out.println("Query: " + result.group(8));
            System.out.println("Fragment: " + result.group(10));
        } else {
            System.out.println("No match found.");
        }
    }
}