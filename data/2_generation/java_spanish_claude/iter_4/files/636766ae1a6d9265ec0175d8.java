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
     * Construye el valor del encabezado HTTP 'Content-Range'.
     * @return valor de 'Content-Range'
     */
    private String buildContentRange() {
        StringBuilder contentRange = new StringBuilder();
        contentRange.append("items ");
        
        if (Objects.isNull(start) || Objects.isNull(end) || Objects.isNull(total)) {
            contentRange.append("*/");
            contentRange.append(Objects.isNull(total) ? "*" : total);
        } else {
            contentRange.append(start);
            contentRange.append("-");
            contentRange.append(end);
            contentRange.append("/");
            contentRange.append(total);
        }
        
        return contentRange.toString();
    }
}