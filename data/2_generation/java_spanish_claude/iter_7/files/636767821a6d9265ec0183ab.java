public class Exception {
    private Throwable thrown;

    /**
     * @return verdadero si getThrown().toString() es una cadena no vacía.
     */
    public boolean hasThrown() {
        if (getThrown() != null) {
            String thrownString = getThrown().toString();
            return thrownString != null && !thrownString.isEmpty();
        }
        return false;
    }

    public Throwable getThrown() {
        return thrown;
    }
}