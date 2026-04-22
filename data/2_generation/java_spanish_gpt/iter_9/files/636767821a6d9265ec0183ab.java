public class Example {
    
    private Throwable thrown;

    public Example(Throwable thrown) {
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
        Example example = new Example(new Exception("Error occurred"));
        System.out.println(example.hasThrown()); // Output: true

        Example example2 = new Example(null);
        System.out.println(example2.hasThrown()); // Output: false
    }
}