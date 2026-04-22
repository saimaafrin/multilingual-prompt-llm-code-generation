import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UriMatcher {

    private final Pattern pattern;

    public UriMatcher(String template) {
        // Convert the template to a regex pattern
        String regex = template.replaceAll("\\{([^/]+)\\}", "([^/]+)");
        this.pattern = Pattern.compile(regex);
    }

    public MatchResult match(CharSequence uri) {
        Matcher matcher = pattern.matcher(uri);
        if (matcher.matches()) {
            return new MatchResult(matcher);
        }
        return null;
    }

    public static final class MatchResult {
        private final Matcher matcher;

        private MatchResult(Matcher matcher) {
            this.matcher = matcher;
        }

        public String get(int group) {
            return matcher.group(group);
        }

        public int groupCount() {
            return matcher.groupCount();
        }
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher("/users/{userId}/posts/{postId}");
        MatchResult result = matcher.match("/users/123/posts/456");

        if (result != null) {
            System.out.println("User ID: " + result.get(1));
            System.out.println("Post ID: " + result.get(2));
        } else {
            System.out.println("No match found.");
        }
    }
}