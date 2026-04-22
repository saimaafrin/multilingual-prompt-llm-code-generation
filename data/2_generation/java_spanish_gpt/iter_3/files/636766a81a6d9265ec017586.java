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
            outputFrame.remove(outputFrame.size() - 1);
        }
    }

    // Método para agregar elementos al output frame (para pruebas)
    public void push(Object element) {
        outputFrame.add(element);
    }

    // Método para obtener el tamaño del output frame (para pruebas)
    public int size() {
        return outputFrame.size();
    }
}