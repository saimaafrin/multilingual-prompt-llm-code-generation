public class ExceptionChecker {

    private Throwable thrown;

    public ExceptionChecker(Throwable thrown) {
        this.thrown = thrown;
    }

    /**
     * @return 如果 getThrown().toString() 是一个非空字符串，则返回真。
     */
    public boolean hasThrown() {
        return thrown != null && !thrown.toString().isEmpty();
    }

    public Throwable getThrown() {
        return thrown;
    }

    public static void main(String[] args) {
        ExceptionChecker checker = new ExceptionChecker(new Exception("An error occurred"));
        System.out.println(checker.hasThrown()); // Output: true

        ExceptionChecker emptyChecker = new ExceptionChecker(null);
        System.out.println(emptyChecker.hasThrown()); // Output: false
    }
}