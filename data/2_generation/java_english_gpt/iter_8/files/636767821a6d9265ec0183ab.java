public class ExceptionChecker {

    private Throwable thrown;

    public ExceptionChecker(Throwable thrown) {
        this.thrown = thrown;
    }

    /** 
     * @return true if getThrown().toString() is a non-empty string.
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