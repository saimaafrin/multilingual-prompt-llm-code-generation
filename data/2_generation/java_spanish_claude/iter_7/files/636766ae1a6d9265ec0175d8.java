import java.util.Objects;

public class ContentRangeBuilder {

    private Long start;
    private Long end; 
    private Long total;
    private String unit = "bytes";

    /**
     * Construye el valor del encabezado HTTP 'Content-Range'.
     * @return valor de 'Content-Range'
     */
    private String buildContentRange() {
        if (Objects.isNull(start) || Objects.isNull(end) || Objects.isNull(total)) {
            return null;
        }

        StringBuilder contentRange = new StringBuilder();
        contentRange.append(unit)
                   .append(" ")
                   .append(start)
                   .append("-")
                   .append(end)
                   .append("/")
                   .append(total);

        return contentRange.toString();
    }

    // Setters for builder pattern
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