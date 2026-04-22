public class Example {
    
    private Throwable thrown;

    public Throwable getThrown() {
        return thrown;
    }

    /** 
     * @return verdadero si getThrown().toString() es una cadena no vacía.
     */
    public boolean hasThrown() {
        return thrown != null && !thrown.toString().isEmpty();
    }
    
    public void setThrown(Throwable thrown) {
        this.thrown = thrown;
    }

    public static void main(String[] args) {
        Example example = new Example();
        example.setThrown(new Exception("An error occurred"));
        System.out.println(example.hasThrown()); // Should print true

        example.setThrown(null);
        System.out.println(example.hasThrown()); // Should print false
    }
}