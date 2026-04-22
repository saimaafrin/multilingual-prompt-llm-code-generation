import java.util.ArrayList;
import java.util.List;

public class FrameStackExtractor {

    /**
     * Extrae tantos tipos abstractos de la "frame stack" de salida como lo describe el descriptor dado.
     * @param descriptor un descriptor de tipo o método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        List<String> extractedTypes = new ArrayList<>();
        
        // Simulación de la extracción de tipos basados en el descriptor
        if (descriptor.startsWith("(") && descriptor.contains(")")) {
            // Es un descriptor de método, extraer tipos de argumento
            int start = descriptor.indexOf('(') + 1;
            int end = descriptor.indexOf(')');
            String args = descriptor.substring(start, end);
            for (String type : args.split(",")) {
                extractedTypes.add(type.trim());
            }
        } else {
            // Es un descriptor de tipo, agregarlo directamente
            extractedTypes.add(descriptor);
        }

        // Aquí se podría hacer algo con los tipos extraídos, como imprimirlos
        for (String type : extractedTypes) {
            System.out.println("Tipo extraído: " + type);
        }
    }

    public static void main(String[] args) {
        FrameStackExtractor extractor = new FrameStackExtractor();
        extractor.pop("(I)V"); // Ejemplo de un descriptor de método
        extractor.pop("Ljava/lang/String;"); // Ejemplo de un descriptor de tipo
    }
}