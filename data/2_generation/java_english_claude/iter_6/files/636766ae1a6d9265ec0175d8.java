import java.util.Objects;

public class ContentRangeBuilder {

    private Long start;
    private Long end; 
    private Long total;

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
        StringBuilder contentRange = new StringBuilder();
        contentRange.append("bytes ");
        
        if (Objects.isNull(start) || Objects.isNull(end) || Objects.isNull(total)) {
            contentRange.append("*/");
            contentRange.append(Objects.nonNull(total) ? total : "*");
        } else {
            contentRange.append(start)
                       .append("-")
                       .append(end)
                       .append("/")
                       .append(total);
        }
        
        return contentRange.toString();
    }
}