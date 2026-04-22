import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public final class URIMatcher {

    private final Pattern pattern;

    public URIMatcher(String regex) {
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
            return matcher.toMatchResult();
        }
        return null;
    }

    public static void main(String[] args) {
        URIMatcher matcher = new URIMatcher("https://example.com/.*");
        MatchResult result = matcher.match("https://example.com/path/to/resource");
        if (result != null) {
            System.out.println("Match found: " + result.group());
        } else {
            System.out.println("No match found.");
        }
    }
}