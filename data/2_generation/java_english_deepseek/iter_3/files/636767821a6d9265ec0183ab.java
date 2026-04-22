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
        if (getThrown() == null) {
            return false;
        }
        String thrownString = getThrown().toString();
        return thrownString != null && !thrownString.isEmpty();
    }

    public static void main(String[] args) {
        Example example = new Example(new RuntimeException("Test Exception"));
        System.out.println(example.hasThrown()); // Output: true
    }
}