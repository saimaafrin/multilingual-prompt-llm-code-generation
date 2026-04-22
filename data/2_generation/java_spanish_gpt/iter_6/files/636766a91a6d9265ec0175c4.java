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
        // Aquí se puede implementar la lógica para analizar el descriptor y extraer los tipos correspondientes.
        
        // Ejemplo de cómo se podría extraer tipos basados en el descriptor
        if (descriptor.startsWith("L")) { // Tipo de objeto
            String type = descriptor.substring(1, descriptor.length() - 1).replace('/', '.');
            stack.add(type);
        } else if (descriptor.startsWith("(")) { // Método
            int endIndex = descriptor.indexOf(')');
            String args = descriptor.substring(1, endIndex);
            for (String arg : args.split(",")) {
                if (!arg.isEmpty()) {
                    String type = arg.replace('L', ' ').trim();
                    stack.add(type);
                }
            }
        }
        // Aquí se pueden agregar más condiciones para otros tipos de descriptores
    }

    public List<String> getStack() {
        return stack;
    }

    public static void main(String[] args) {
        StackExtractor extractor = new StackExtractor();
        extractor.pop("Ljava/lang/String;");
        extractor.pop("(Ljava/lang/String;I)V");
        System.out.println(extractor.getStack());
    }
}