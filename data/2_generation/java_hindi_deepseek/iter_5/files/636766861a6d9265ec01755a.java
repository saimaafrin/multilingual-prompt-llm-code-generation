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
        // Define a pattern to match URIs (example: any sequence of characters)
        Pattern pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
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