import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class URIMatcher {

    /**
     * एक URI को पैटर्न के खिलाफ मिलाएं।
     * @param uri वह URI जिसे टेम्पलेट के खिलाफ मिलाना है।
     * @return मिलान का परिणाम, अन्यथा यदि कोई मिलान नहीं होता है तो null।
     */
    public final MatchResult match(CharSequence uri) {
        // Define a pattern to match against the URI
        // This is a simple example pattern that matches URIs starting with "http://" or "https://"
        Pattern pattern = Pattern.compile("^(http|https)://([^/]+)(/.*)?$");
        Matcher matcher = pattern.matcher(uri);

        // Check if the URI matches the pattern
        if (matcher.matches()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        URIMatcher uriMatcher = new URIMatcher();
        CharSequence uri = "https://example.com/path/to/resource";
        MatchResult result = uriMatcher.match(uri);

        if (result != null) {
            System.out.println("Match found:");
            System.out.println("Protocol: " + result.group(1));
            System.out.println("Domain: " + result.group(2));
            System.out.println("Path: " + result.group(3));
        } else {
            System.out.println("No match found.");
        }
    }
}