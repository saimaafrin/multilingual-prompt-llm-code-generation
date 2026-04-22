import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class StringMatchFilter extends Filter {

    private String stringToMatch;
    private boolean acceptOnMatch = true;

    /**
     * 如果没有字符串匹配，则返回 {@link Filter#NEUTRAL}。
     */
    public int decide(LoggingEvent event) {
        // If no string to match against, return neutral
        if (stringToMatch == null) {
            return Filter.NEUTRAL; 
        }

        // Get the message from the logging event
        String message = event.getRenderedMessage();
        
        // If message is null, return neutral
        if (message == null) {
            return Filter.NEUTRAL;
        }

        // Check if message contains the string to match
        boolean matched = message.contains(stringToMatch);

        // If matched and acceptOnMatch is true, accept the event
        if (matched && acceptOnMatch) {
            return Filter.ACCEPT;
        }
        
        // If matched and acceptOnMatch is false, deny the event
        if (matched && !acceptOnMatch) {
            return Filter.DENY;
        }

        // If no match found, return neutral
        return Filter.NEUTRAL;
    }

    public void setStringToMatch(String stringToMatch) {
        this.stringToMatch = stringToMatch;
    }

    public void setAcceptOnMatch(boolean acceptOnMatch) {
        this.acceptOnMatch = acceptOnMatch;
    }
}