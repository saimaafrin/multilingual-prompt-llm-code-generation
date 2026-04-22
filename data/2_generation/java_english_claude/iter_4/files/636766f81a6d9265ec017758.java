import java.util.Objects;

public class Type {
    private String name;
    private String value;
    
    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}