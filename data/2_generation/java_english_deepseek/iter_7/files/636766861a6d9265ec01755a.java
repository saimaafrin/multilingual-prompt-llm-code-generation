import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class UriMatcher {

    private final Pattern pattern;

    public UriMatcher(String template) {
        // Convert the template to a regex pattern
        String regex = template.replaceAll("\\{.*?\\}", "([^/]+)");
        this.pattern = Pattern.compile(regex);
    }

    public final MatchResult match(CharSequence uri) {
        Matcher matcher = pattern.matcher(uri);
        if (matcher.matches()) {
            return matcher.toMatchResult();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        UriMatcher matcher = new UriMatcher("/users/{userId}/posts/{postId}");
        MatchResult result = matcher.match("/users/123/posts/456");

        if (result != null) {
            System.out.println("Match found!");
            for (int i = 1; i <= result.groupCount(); i++) {
                System.out.println("Group " + i + ": " + result.group(i));
            }
        } else {
            System.out.println("No match found.");
        }
    }
}