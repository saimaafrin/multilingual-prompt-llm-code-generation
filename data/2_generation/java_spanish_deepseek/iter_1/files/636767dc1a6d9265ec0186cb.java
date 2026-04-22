import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigInitializer {

    /**
     * Inicializa la configuración, como verificar la ruta de distribución.
     */
    public void init() {
        // Verificar la ruta de distribución
        String distributionPath = "/ruta/de/distribucion"; // Cambia esto a la ruta correcta
        Path path = Paths.get(distributionPath);

        if (Files.exists(path)) {
            System.out.println("La ruta de distribución existe: " + distributionPath);
        } else {
            System.out.println("La ruta de distribución no existe: " + distributionPath);
        }
    }

    public static void main(String[] args) {
        ConfigInitializer initializer = new ConfigInitializer();
        initializer.init();
    }
}