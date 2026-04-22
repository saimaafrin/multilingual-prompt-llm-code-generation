import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class UriMatcher {

    /**
     * Match a URI against the pattern.
     * @param uri the uri to match against the template.
     * @return the match result, otherwise null if no match occurs.
     */
    public final MatchResult match(CharSequence uri) {
        // Define a simple pattern for demonstration purposes
        // This pattern matches URIs like "/resource/{id}"
        String patternString = "^/resource/(\\d+)$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(uri);

        if (matcher.matches()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher();
        MatchResult result = matcher.match("/resource/123");

        if (result != null) {
            System.out.println("Match found: " + result.group(0));
        } else {
            System.out.println("No match found.");
        }
    }
}