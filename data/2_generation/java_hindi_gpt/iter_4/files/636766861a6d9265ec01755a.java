import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {
    private final Pattern pattern;

    public UriMatcher(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    /** 
     * एक URI को पैटर्न के खिलाफ मिलाएं।
     * @param uri वह URI जिसे टेम्पलेट के खिलाफ मिलाना है।
     * @return मिलान का परिणाम, अन्यथा यदि कोई मिलान नहीं होता है तो null।
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
        UriMatcher uriMatcher = new UriMatcher("^(http|https)://.*$");
        MatchResult result = uriMatcher.match("https://example.com");
        if (result != null) {
            System.out.println("Match found! Group count: " + result.groupCount());
        } else {
            System.out.println("No match found.");
        }
    }
}