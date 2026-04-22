public class LineNumberManager {
    
    private int lineNumber;

    /** 
     * Agrega un número de línea de origen correspondiente a esta etiqueta.
     * @param lineNumber un número de línea de origen (que debe ser estrictamente positivo).
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("El número de línea debe ser estrictamente positivo.");
        }
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public static void main(String[] args) {
        LineNumberManager manager = new LineNumberManager();
        manager.addLineNumber(5);
        System.out.println("Número de línea agregado: " + manager.getLineNumber());
    }
}