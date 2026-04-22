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
     * 构建 'Content-Range' HTTP 头部值。
     * @return 'Content-Range' 值
     */
    private String buildContentRange() {
        StringBuilder contentRange = new StringBuilder();
        contentRange.append("bytes ");
        
        if (Objects.nonNull(start) && Objects.nonNull(end)) {
            contentRange.append(start)
                       .append("-")
                       .append(end);
        } else {
            contentRange.append("*");
        }
        
        contentRange.append("/");
        
        if (Objects.nonNull(total)) {
            contentRange.append(total);
        } else {
            contentRange.append("*"); 
        }
        
        return contentRange.toString();
    }
}