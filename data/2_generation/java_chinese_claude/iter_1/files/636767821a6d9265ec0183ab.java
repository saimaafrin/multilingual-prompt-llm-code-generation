public class ExceptionHandler {
    private Throwable thrown;

    public ExceptionHandler() {
        this.thrown = null;
    }

    public void setThrown(Throwable thrown) {
        this.thrown = thrown;
    }

    public Throwable getThrown() {
        return this.thrown;
    }

    public boolean hasThrown() {
        return getThrown() != null && getThrown().toString() != null && !getThrown().toString().isEmpty();
    }
}