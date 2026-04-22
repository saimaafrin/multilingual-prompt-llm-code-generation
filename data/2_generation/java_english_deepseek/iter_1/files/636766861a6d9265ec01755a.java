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
        // This pattern matches URIs like "/resource/123" where 123 is a number
        String patternString = "^/resource/(\\d+)$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(uri);

        if (matcher.matches()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }
}