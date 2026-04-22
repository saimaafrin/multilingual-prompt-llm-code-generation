import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class UriMatcher {

    private final Pattern pattern;

    public UriMatcher(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    /**
     * Match a URI against the pattern.
     * @param uri the uri to match against the template.
     * @return the match result, otherwise null if no match occurs.
     */
    public final MatchResult match(CharSequence uri) {
        Matcher matcher = pattern.matcher(uri);
        if (matcher.matches()) {
            return matcher.toMatchResult();
        }
        return null;
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher("https://example.com/.*");
        MatchResult result = matcher.match("https://example.com/resource");
        if (result != null) {
            System.out.println("Match found: " + result.group());
        } else {
            System.out.println("No match found.");
        }
    }
}