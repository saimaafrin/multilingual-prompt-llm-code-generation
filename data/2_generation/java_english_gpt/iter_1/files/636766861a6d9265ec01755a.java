import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UriMatcher {
    private final Pattern pattern;

    public UriMatcher(String template) {
        this.pattern = Pattern.compile(template);
    }

    /**
     * Match a URI against the pattern.
     * @param uri the uri to match against the template.
     * @return the match result, otherwise null if no match occurs.
     */
    public final MatchResult match(CharSequence uri) {
        Matcher matcher = pattern.matcher(uri);
        if (matcher.matches()) {
            return new MatchResult(matcher);
        }
        return null;
    }

    public static class MatchResult {
        private final Matcher matcher;

        public MatchResult(Matcher matcher) {
            this.matcher = matcher;
        }

        public String group(int group) {
            return matcher.group(group);
        }

        public int groupCount() {
            return matcher.groupCount();
        }
    }

    public static void main(String[] args) {
        UriMatcher uriMatcher = new UriMatcher("^(https?://)?(www\\.)?example\\.com(/.*)?$");
        MatchResult result = uriMatcher.match("https://www.example.com/test");
        if (result != null) {
            System.out.println("Matched! Group count: " + result.groupCount());
        } else {
            System.out.println("No match.");
        }
    }
}