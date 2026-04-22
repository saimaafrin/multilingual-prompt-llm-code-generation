public class ExceptionChecker {
    private Throwable thrown;

    public ExceptionChecker(Throwable thrown) {
        this.thrown = thrown;
    }

    public boolean hasThrown() {
        return thrown != null && !thrown.toString().isEmpty();
    }

    public static void main(String[] args) {
        // Example usage
        ExceptionChecker checker = new ExceptionChecker(new RuntimeException("Test Exception"));
        System.out.println(checker.hasThrown()); // Output: true

        ExceptionChecker checker2 = new ExceptionChecker(null);
        System.out.println(checker2.hasThrown()); // Output: false
    }
}