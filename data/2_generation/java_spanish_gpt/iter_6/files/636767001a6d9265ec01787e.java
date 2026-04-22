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

    // Método para agregar texto a la cadena
    public void append(String text) {
        stringBuilder.append(text);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.append("Hola, ");
        myClass.append("mundo!");
        System.out.println(myClass.toString()); // Imprime: Hola, mundo!
    }
}