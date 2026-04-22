import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UriMatcher {
    private final Pattern pattern;

    public UriMatcher(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    /**
     * Compara una URI con el patrón.
     * @param uri la URI a comparar con la plantilla.
     * @return el resultado de la coincidencia, o null si no hay coincidencia.
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

        public int start(int group) {
            return matcher.start(group);
        }

        public int end(int group) {
            return matcher.end(group);
        }

        public int groupCount() {
            return matcher.groupCount();
        }
    }

    public static void main(String[] args) {
        UriMatcher uriMatcher = new UriMatcher("^(https?://)(www\\.)?example\\.com(/.*)?$");
        MatchResult result = uriMatcher.match("https://www.example.com/path");

        if (result != null) {
            System.out.println("Match found!");
            System.out.println("Group 0: " + result.group(0));
        } else {
            System.out.println("No match found.");
        }
    }
}