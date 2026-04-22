public class MyClass {
    
    private StringBuilder stringBuilder;

    public MyClass() {
        stringBuilder = new StringBuilder();
    }

    /** 
     * <p> Obtiene la cadena construida por este constructor. </p>
     * @return la cadena construida
     */
    public String toString() {
        return stringBuilder.toString();
    }

    // Method to append a string to the builder for demonstration purposes
    public void append(String str) {
        stringBuilder.append(str);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.append("Hello, ");
        myClass.append("World!");
        System.out.println(myClass.toString()); // Output: Hello, World!
    }
}