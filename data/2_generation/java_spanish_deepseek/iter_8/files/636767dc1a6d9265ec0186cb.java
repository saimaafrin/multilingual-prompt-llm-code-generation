import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * Inicializa la configuración, como verificar la ruta de distribución.
     */
    public void init() {
        // Verificar si la ruta de distribución existe
        String distributionPath = "/ruta/de/distribucion"; // Cambia esto por la ruta correcta
        Path path = Paths.get(distributionPath);

        if (Files.exists(path)) {
            System.out.println("La ruta de distribución existe: " + distributionPath);
        } else {
            System.out.println("La ruta de distribución no existe: " + distributionPath);
            // Aquí podrías lanzar una excepción o manejar el error de otra manera
        }
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer();
        initializer.init();
    }
}