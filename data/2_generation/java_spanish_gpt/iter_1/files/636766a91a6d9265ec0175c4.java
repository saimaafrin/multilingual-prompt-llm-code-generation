import java.util.ArrayList;
import java.util.List;

public class StackExtractor {

    private List<String> stack = new ArrayList<>();

    /**
     * Extrae tantos tipos abstractos de la "frame stack" de salida como lo describe el descriptor dado.
     * @param descriptor un descriptor de tipo o método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        // Simulación de la extracción de tipos abstractos de la "frame stack"
        // Aquí se asume que el descriptor es una cadena que describe los tipos
        // Por simplicidad, se simula la extracción de tipos a partir del descriptor

        // Limpiar la stack antes de la extracción
        stack.clear();

        // Simulación de la lógica de extracción basada en el descriptor
        if (descriptor != null && !descriptor.isEmpty()) {
            // Por ejemplo, si el descriptor es "I", se extrae un tipo entero
            if (descriptor.equals("I")) {
                stack.add("Integer");
            } else if (descriptor.equals("Ljava/lang/String;")) {
                stack.add("String");
            } else if (descriptor.equals("(I)V")) {
                stack.add("void");
                stack.add("Integer");
            } else {
                // Agregar otros tipos según sea necesario
                stack.add("UnknownType");
            }
        }
    }

    public List<String> getStack() {
        return stack;
    }

    public static void main(String[] args) {
        StackExtractor extractor = new StackExtractor();
        extractor.pop("I");
        System.out.println(extractor.getStack()); // Output: [Integer]
        
        extractor.pop("Ljava/lang/String;");
        System.out.println(extractor.getStack()); // Output: [String]
        
        extractor.pop("(I)V");
        System.out.println(extractor.getStack()); // Output: [void, Integer]
    }
}