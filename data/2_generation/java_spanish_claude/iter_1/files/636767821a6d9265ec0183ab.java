public class Exception {
    private Throwable thrown;

    /**
     * @return verdadero si getThrown().toString() es una cadena no vacía.
     */
    public boolean hasThrown() {
        if (getThrown() != null && !getThrown().toString().isEmpty()) {
            return true;
        }
        return false;
    }

    public Throwable getThrown() {
        return thrown;
    }
}