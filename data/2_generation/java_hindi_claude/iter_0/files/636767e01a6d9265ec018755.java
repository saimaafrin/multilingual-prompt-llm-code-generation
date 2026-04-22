import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentBuilder {

    /**
     * Build content, if it has ats someone set the ats
     * @param content The raw content string
     * @return Processed content with ats extracted
     */
    public static String buildContent(String content) {
        if (content == null || content.isEmpty()) {
            return "";
        }

        // Pattern to match @mentions
        Pattern pattern = Pattern.compile("@\\w+");
        Matcher matcher = pattern.matcher(content);
        
        List<String> mentions = new ArrayList<>();
        
        // Find all @mentions
        while (matcher.find()) {
            String mention = matcher.group();
            mentions.add(mention.substring(1)); // Remove @ symbol
        }

        // If mentions found, process them
        if (!mentions.isEmpty()) {
            // Replace @mentions with proper format
            for (String mention : mentions) {
                content = content.replace("@" + mention, "[AT]" + mention + "[/AT]");
            }
        }

        return content;
    }
}