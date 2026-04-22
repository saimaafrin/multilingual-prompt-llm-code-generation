public class ExceptionChecker {
    private Throwable thrown;

    public ExceptionChecker(Throwable thrown) {
        this.thrown = thrown;
    }

    public boolean hasThrown() {
        if (thrown == null) {
            return false;
        }
        String thrownString = thrown.toString();
        return thrownString != null && !thrownString.isEmpty();
    }

    public static void main(String[] args) {
        // Example usage
        ExceptionChecker checker = new ExceptionChecker(new RuntimeException("Test exception"));
        System.out.println(checker.hasThrown()); // Output: true

        ExceptionChecker checker2 = new ExceptionChecker(null);
        System.out.println(checker2.hasThrown()); // Output: false
    }
}