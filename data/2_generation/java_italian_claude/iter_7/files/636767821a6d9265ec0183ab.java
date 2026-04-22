public class Exception {
    private Throwable thrown;

    /**
     * @return true se getThrown().toString() è una stringa non vuota.
     */
    public boolean hasThrown() {
        return thrown != null && !thrown.toString().isEmpty();
    }

    public Throwable getThrown() {
        return thrown;
    }
}