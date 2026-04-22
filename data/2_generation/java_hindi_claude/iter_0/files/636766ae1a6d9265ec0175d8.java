import java.util.Objects;

public class ContentRangeBuilder {
    private Long start;
    private Long end;
    private Long total;
    private String unit = "bytes";

    public String buildContentRangeHeaderValue() {
        Objects.requireNonNull(start, "Start position cannot be null");
        Objects.requireNonNull(end, "End position cannot be null"); 
        Objects.requireNonNull(total, "Total size cannot be null");

        if (start < 0 || end < 0 || total < 0) {
            throw new IllegalArgumentException("Range values cannot be negative");
        }

        if (start > end) {
            throw new IllegalArgumentException("Start position cannot be greater than end position");
        }

        if (end >= total) {
            throw new IllegalArgumentException("End position cannot be greater than or equal to total size");
        }

        return String.format("%s %d-%d/%d", unit, start, end, total);
    }

    // Builder setters
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

    public ContentRangeBuilder setUnit(String unit) {
        this.unit = unit;
        return this;
    }
}