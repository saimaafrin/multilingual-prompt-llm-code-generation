public class Example {
    private Throwable thrown;

    public Example(Throwable thrown) {
        this.thrown = thrown;
    }

    public Throwable getThrown() {
        return thrown;
    }

    /**
     * @return true if getThrown().toString() is a non-empty string.
     */
    public boolean hasThrown() {
        Throwable thrown = getThrown();
        return thrown != null && !thrown.toString().isEmpty();
    }

    public static void main(String[] args) {
        Example example = new Example(new RuntimeException("Error occurred"));
        System.out.println(example.hasThrown()); // Output: true
    }
}