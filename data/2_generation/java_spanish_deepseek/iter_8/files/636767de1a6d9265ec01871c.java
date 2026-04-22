import java.util.HashMap;
import java.util.Map;

public class Acumulador {
    private Map<String, Long> mapa;

    public Acumulador() {
        mapa = new HashMap<>();
    }

    /**
     * Acumula el valor con el valor existente en la misma clave dada.
     */
    public void acumulacionDeValor(String clave, Long valor) {
        if (mapa.containsKey(clave)) {
            Long valorExistente = mapa.get(clave);
            mapa.put(clave, valorExistente + valor);
        } else {
            mapa.put(clave, valor);
        }
    }

    public Long obtenerValor(String clave) {
        return mapa.getOrDefault(clave, 0L);
    }

    public static void main(String[] args) {
        Acumulador acumulador = new Acumulador();
        acumulador.acumulacionDeValor("clave1", 10L);
        acumulador.acumulacionDeValor("clave1", 20L);
        System.out.println(acumulador.obtenerValor("clave1")); // Debería imprimir 30
    }
}