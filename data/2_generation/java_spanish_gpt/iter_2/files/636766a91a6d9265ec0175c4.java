import java.util.ArrayList;
import java.util.List;

public class FrameStackExtractor {

    /**
     * Extrae tantos tipos abstractos de la "frame stack" de salida como lo describe el descriptor dado.
     * @param descriptor un descriptor de tipo o método (en cuyo caso se extraen sus tipos de argumento).
     */
    private void pop(final String descriptor) {
        List<String> types = new ArrayList<>();
        
        // Simulación de la extracción de tipos basados en el descriptor
        if (descriptor.startsWith("(") && descriptor.contains(")")) {
            // Extraer tipos de argumento de un descriptor de método
            int start = descriptor.indexOf('(') + 1;
            int end = descriptor.indexOf(')');
            String args = descriptor.substring(start, end);
            for (String type : args.split(",")) {
                types.add(type.trim());
            }
        } else {
            // Considerar el descriptor como un tipo
            types.add(descriptor);
        }

        // Simulación de la operación de "pop" en la stack
        for (String type : types) {
            System.out.println("Popped type: " + type);
        }
    }

    public static void main(String[] args) {
        FrameStackExtractor extractor = new FrameStackExtractor();
        extractor.pop("(I)V"); // Ejemplo de un descriptor de método
        extractor.pop("Ljava/lang/String;"); // Ejemplo de un tipo
    }
}