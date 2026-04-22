import java.util.HashMap;
import java.util.Map;

public class Acumulador {
    private Map<String, Long> acumulador;

    public Acumulador() {
        this.acumulador = new HashMap<>();
    }

    /**
     * Acumula el valor con el valor existente en la misma clave dada.
     */
    public void acumulacionDeValor(String clave, Long valor) {
        if (clave == null || valor == null) {
            return;
        }
        
        Long valorActual = acumulador.getOrDefault(clave, 0L);
        acumulador.put(clave, valorActual + valor);
    }
}