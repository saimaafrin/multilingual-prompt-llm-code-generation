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

    // Method to add elements for testing purposes
    public void push(Object element) {
        outputFrame.add(element);
    }

    // Method to get the current size of the output frame
    public int size() {
        return outputFrame.size();
    }

    public static void main(String[] args) {
        OutputFrame frame = new OutputFrame();
        frame.push("Element 1");
        frame.push("Element 2");
        frame.push("Element 3");
        
        System.out.println("Size before pop: " + frame.size());
        frame.pop(2);
        System.out.println("Size after pop: " + frame.size());
    }
}