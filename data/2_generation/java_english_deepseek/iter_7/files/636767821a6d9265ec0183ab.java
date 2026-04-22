public class ExceptionChecker {
    private Throwable thrown;

    public ExceptionChecker(Throwable thrown) {
        this.thrown = thrown;
    }

    /**
     * @return true if getThrown().toString() is a non-empty string.
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

    public static void main(String[] args) {
        // Example usage
        ExceptionChecker checker = new ExceptionChecker(new RuntimeException("Test Exception"));
        System.out.println(checker.hasThrown()); // Should print true
    }
}