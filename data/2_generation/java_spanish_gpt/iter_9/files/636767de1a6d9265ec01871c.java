import java.util.HashMap;
import java.util.Map;

public class Accumulador {
    private Map<String, Long> acumulaciones;

    public Accumulador() {
        acumulaciones = new HashMap<>();
    }

    /** 
     * Acumula el valor con el valor existente en la misma clave dada.
     */
    public void acumulacionDeValor(String clave, Long valor) {
        acumulaciones.put(clave, acumulaciones.getOrDefault(clave, 0L) + valor);
    }

    public Map<String, Long> getAcumulaciones() {
        return acumulaciones;
    }

    public static void main(String[] args) {
        Accumulador acumulador = new Accumulador();
        acumulador.acumulacionDeValor("clave1", 10L);
        acumulador.acumulacionDeValor("clave1", 5L);
        acumulador.acumulacionDeValor("clave2", 20L);
        
        System.out.println(acumulador.getAcumulaciones()); // {clave1=15, clave2=20}
    }
}