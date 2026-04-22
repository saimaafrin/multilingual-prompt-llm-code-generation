public class ExceptionChecker {
    
    private Throwable thrown;

    public ExceptionChecker(Throwable thrown) {
        this.thrown = thrown;
    }

    /** 
     * @return verdadero si getThrown().toString() es una cadena no vacía.
     */
    public boolean hasThrown() {
        return thrown != null && !thrown.toString().isEmpty();
    }

    public Throwable getThrown() {
        return thrown;
    }

    public static void main(String[] args) {
        ExceptionChecker checker = new ExceptionChecker(new Exception("Error occurred"));
        System.out.println(checker.hasThrown()); // Output: true

        ExceptionChecker emptyChecker = new ExceptionChecker(new Exception());
        System.out.println(emptyChecker.hasThrown()); // Output: false

        ExceptionChecker nullChecker = new ExceptionChecker(null);
        System.out.println(nullChecker.hasThrown()); // Output: false
    }
}