import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class ConfigurationManager {
    private static final Logger LOGGER = Logger.getLogger(ConfigurationManager.class.getName());
    private static final String DISTRIBUTION_PATH = "dist/";
    
    /**
     * inicializa la configuración, como verificar la ruta de distribución
     */
    public void init() {
        try {
            // Verificar si existe el directorio de distribución
            File distributionDir = new File(DISTRIBUTION_PATH);
            if (!distributionDir.exists()) {
                boolean created = distributionDir.mkdirs();
                if (created) {
                    LOGGER.info("Directorio de distribución creado exitosamente");
                } else {
                    LOGGER.warning("No se pudo crear el directorio de distribución");
                }
            }

            // Verificar permisos de escritura
            if (!distributionDir.canWrite()) {
                LOGGER.severe("No hay permisos de escritura en el directorio de distribución");
                throw new SecurityException("Sin permisos de escritura en " + DISTRIBUTION_PATH);
            }

            LOGGER.info("Inicialización completada correctamente");
            
        } catch (SecurityException e) {
            LOGGER.log(Level.SEVERE, "Error de seguridad durante la inicialización", e);
            throw e;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error durante la inicialización", e);
            throw new RuntimeException("Error en la inicialización", e);
        }
    }
}