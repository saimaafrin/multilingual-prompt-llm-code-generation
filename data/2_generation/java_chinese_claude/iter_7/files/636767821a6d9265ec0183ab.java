import java.lang.Throwable;

public class ExceptionHandler {
    private Throwable thrown;
    
    /**
     * @return 如果 getThrown().toString() 是一个非空字符串，则返回真。
     */
    public boolean hasThrown() {
        if (thrown == null) {
            return false;
        }
        String thrownString = thrown.toString();
        return thrownString != null && !thrownString.isEmpty();
    }
    
    public Throwable getThrown() {
        return thrown;
    }
    
    public void setThrown(Throwable thrown) {
        this.thrown = thrown;
    }
}