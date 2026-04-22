import java.util.ArrayList;
import java.util.List;

public class StackFrameExtractor {

    /**
     * Extrae tantos tipos abstractos de la pila de marcos de salida como lo describe el descriptor dado.
     * @param descriptor un tipo o descriptor de método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        List<String> extractedTypes = new ArrayList<>();
        
        // Simulación de la extracción de tipos a partir del descriptor
        if (descriptor.startsWith("(") && descriptor.contains(")")) {
            int startIndex = descriptor.indexOf('(') + 1;
            int endIndex = descriptor.indexOf(')');
            String args = descriptor.substring(startIndex, endIndex);
            
            if (!args.isEmpty()) {
                String[] types = args.split(",");
                for (String type : types) {
                    extractedTypes.add(type.trim());
                }
            }
        } else {
            // Si el descriptor no es un descriptor de método, se puede manejar de otra manera
            extractedTypes.add(descriptor);
        }

        // Aquí se podría hacer algo con los tipos extraídos, como imprimirlos
        for (String type : extractedTypes) {
            System.out.println("Tipo extraído: " + type);
        }
    }

    public static void main(String[] args) {
        StackFrameExtractor extractor = new StackFrameExtractor();
        extractor.pop("(I,Ljava/lang/String;)V"); // Ejemplo de uso
    }
}