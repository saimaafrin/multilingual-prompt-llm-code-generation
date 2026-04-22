import java.util.Objects;

public class ContentRangeBuilder {
    private Long start;
    private Long end; 
    private Long total;
    
    public ContentRangeBuilder() {
        this.start = 0L;
        this.end = 0L;
        this.total = 0L;
    }
    
    public ContentRangeBuilder(Long start, Long end, Long total) {
        this.start = start;
        this.end = end;
        this.total = total;
    }

    /**
     * Build the 'Content-Range' HTTP Header value.
     * @return 'Content-Range' value
     */
    private String buildContentRange() {
        if (Objects.isNull(start) || Objects.isNull(end) || Objects.isNull(total)) {
            return "";
        }
        
        StringBuilder contentRange = new StringBuilder();
        contentRange.append("bytes ");
        contentRange.append(start);
        contentRange.append("-");
        contentRange.append(end);
        contentRange.append("/");
        contentRange.append(total);
        
        return contentRange.toString();
    }
}