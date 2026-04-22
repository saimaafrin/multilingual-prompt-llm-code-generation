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
        // Basado en el descriptor proporcionado, se extraen los tipos correspondientes
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // Aquí se simula la lógica de extracción de tipos
        // En un caso real, esto podría implicar análisis de bytecode o estructuras de datos complejas
        String[] types = descriptor.split(",");
        for (String type : types) {
            stack.add(type.trim());
        }

        // Imprimir los tipos extraídos para verificación
        System.out.println("Tipos extraídos: " + stack);
    }

    public static void main(String[] args) {
        StackExtractor extractor = new StackExtractor();
        extractor.pop("int, String, double");
    }
}