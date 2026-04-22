import java.lang.Throwable;

public class ExceptionUtils {
    private Throwable thrown;

    public ExceptionUtils(Throwable thrown) {
        this.thrown = thrown;
    }

    public Throwable getThrown() {
        return thrown;
    }

    public boolean hasMessage() {
        return getThrown() != null && getThrown().toString() != null && !getThrown().toString().isEmpty();
    }
}