import java.text.MessageFormat;

public class ContentRangeBuilder {

    private long start;
    private long end; 
    private long total;
    
    public ContentRangeBuilder(long start, long end, long total) {
        this.start = start;
        this.end = end;
        this.total = total;
    }

    /**
     * Costruisce il valore dell'intestazione HTTP 'Content-Range'.
     * @return valore 'Content-Range'
     */
    private String buildContentRange() {
        return MessageFormat.format("bytes {0}-{1}/{2}", start, end, total);
    }
}