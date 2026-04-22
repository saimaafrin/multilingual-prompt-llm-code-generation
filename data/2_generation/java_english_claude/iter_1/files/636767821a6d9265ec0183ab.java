public class Exception {
    private Throwable thrown;

    /**
     * @return true if getThrown().toString() is a non-empty string.
     */
    public boolean hasThrown() {
        if (thrown != null) {
            String thrownString = thrown.toString();
            return thrownString != null && !thrownString.isEmpty();
        }
        return false;
    }

    public Throwable getThrown() {
        return thrown;
    }
}