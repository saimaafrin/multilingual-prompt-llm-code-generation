import java.util.Objects;

public class MyClass {
    private String field1;
    private int field2;
    private Object field3;
    
    @Override 
    public int hashCode() {
        return Objects.hash(field1, field2, field3);
    }
}