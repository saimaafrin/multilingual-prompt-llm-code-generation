public class ExceptionChecker {
    private Throwable thrown;

    public ExceptionChecker(Throwable thrown) {
        this.thrown = thrown;
    }

    public boolean hasThrown() {
        return thrown != null && thrown.toString() != null && !thrown.toString().isEmpty();
    }

    public static void main(String[] args) {
        // Example usage
        ExceptionChecker checker = new ExceptionChecker(new RuntimeException("Test exception"));
        System.out.println(checker.hasThrown()); // Should print true
    }
}