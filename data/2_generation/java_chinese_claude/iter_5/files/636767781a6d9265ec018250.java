import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class StringMatchFilter extends Filter {

    private String stringToMatch;
    private boolean acceptOnMatch = true;

    /**
     * 如果没有字符串匹配，则返回 {@link Filter#NEUTRAL}。
     */
    public int decide(LoggingEvent event) {
        if(stringToMatch == null || event == null) {
            return Filter.NEUTRAL; 
        }

        String message = event.getRenderedMessage();
        
        if(message == null) {
            return Filter.NEUTRAL;
        }

        if(message.contains(stringToMatch)) {
            return acceptOnMatch ? Filter.ACCEPT : Filter.DENY;
        }

        return Filter.NEUTRAL;
    }

    public void setStringToMatch(String stringToMatch) {
        this.stringToMatch = stringToMatch;
    }

    public void setAcceptOnMatch(boolean acceptOnMatch) {
        this.acceptOnMatch = acceptOnMatch;
    }

    public String getStringToMatch() {
        return stringToMatch;
    }

    public boolean isAcceptOnMatch() {
        return acceptOnMatch;
    }
}