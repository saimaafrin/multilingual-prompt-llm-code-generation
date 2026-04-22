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
            return;
        }
        int toRemove = Math.min(elements, outputFrame.size());
        for (int i = 0; i < toRemove; i++) {
            outputFrame.remove(outputFrame.size() - 1);
        }
    }

    // Additional methods to manipulate the outputFrame for testing purposes
    public void push(Object element) {
        outputFrame.add(element);
    }

    public List<Object> getOutputFrame() {
        return outputFrame;
    }
}