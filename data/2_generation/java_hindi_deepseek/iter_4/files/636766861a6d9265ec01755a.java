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
}