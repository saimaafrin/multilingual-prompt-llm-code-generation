import java.util.Objects;

public class ContentRangeBuilder {
    
    private Long start;
    private Long end; 
    private Long total;
    
    public String buildContentRangeHeader() {
        Objects.requireNonNull(start, "Start value cannot be null");
        Objects.requireNonNull(end, "End value cannot be null");
        Objects.requireNonNull(total, "Total value cannot be null");
        
        if (start < 0 || end < 0 || total < 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        
        if (start > end) {
            throw new IllegalArgumentException("Start value must be less than or equal to end value");
        }
        
        if (end >= total) {
            end = total - 1;
        }
        
        return String.format("bytes %d-%d/%d", start, end, total);
    }
    
    public ContentRangeBuilder setStart(Long start) {
        this.start = start;
        return this;
    }
    
    public ContentRangeBuilder setEnd(Long end) {
        this.end = end;
        return this;
    }
    
    public ContentRangeBuilder setTotal(Long total) {
        this.total = total;
        return this;
    }
}