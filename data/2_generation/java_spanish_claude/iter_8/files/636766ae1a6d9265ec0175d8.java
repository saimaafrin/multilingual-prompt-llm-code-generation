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
        
        if (Objects.nonNull(start)) {
            contentRange.append(start);
        } else {
            contentRange.append("*");
        }
        
        contentRange.append("-");
        
        if (Objects.nonNull(end)) {
            contentRange.append(end);
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