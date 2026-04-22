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
        String regex = "^(http://|https://).*";
        Pattern pattern = Pattern.compile(regex);
        
        // Create a matcher for the input URI
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
        CharSequence uri = "https://example.com";
        MatchResult result = uriMatcher.match(uri);
        
        if (result != null) {
            System.out.println("URI matched: " + result.group());
        } else {
            System.out.println("No match found.");
        }
    }
}