public class Exception {
    private Throwable thrown;

    /**
     * @return true if getThrown().toString() is a non-empty string.
     */
    public boolean hasThrown() {
        if (getThrown() == null) {
            return false;
        }
        String thrownString = getThrown().toString();
        return thrownString != null && !thrownString.isEmpty();
    }

    // Helper method to get the thrown exception
    public Throwable getThrown() {
        return thrown;
    }
}