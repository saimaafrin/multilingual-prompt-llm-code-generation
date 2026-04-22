public class ExceptionChecker {
    private Throwable thrown;

    public ExceptionChecker(Throwable thrown) {
        this.thrown = thrown;
    }

    /**
     * @return 如果 getThrown().toString() 是一个非空字符串，则返回真。
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