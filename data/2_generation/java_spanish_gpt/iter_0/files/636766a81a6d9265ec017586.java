public class OutputFrame {
    private List<Object> outputFrame;

    public OutputFrame() {
        this.outputFrame = new ArrayList<>();
    }

    /**
     * Elimina el número dado de tipos abstractos del "output frame" de salida.
     * @param elements el número de tipos abstractos que deben ser eliminados.
     */
    private void pop(final int elements) {
        if (elements <= 0) {
            return; // No hay nada que eliminar
        }
        int toRemove = Math.min(elements, outputFrame.size());
        for (int i = 0; i < toRemove; i++) {
            outputFrame.remove(outputFrame.size() - 1); // Elimina el último elemento
        }
    }

    // Método para agregar elementos al output frame (para pruebas)
    public void push(Object element) {
        outputFrame.add(element);
    }

    // Método para ver el contenido del output frame (para pruebas)
    public List<Object> getOutputFrame() {
        return outputFrame;
    }

    public static void main(String[] args) {
        OutputFrame frame = new OutputFrame();
        frame.push("Element 1");
        frame.push("Element 2");
        frame.push("Element 3");
        
        System.out.println("Before pop: " + frame.getOutputFrame());
        frame.pop(2);
        System.out.println("After pop: " + frame.getOutputFrame());
    }
}