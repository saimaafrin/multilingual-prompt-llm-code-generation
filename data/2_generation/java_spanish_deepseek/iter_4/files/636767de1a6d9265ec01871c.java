import java.util.HashMap;
import java.util.Map;

public class Acumulador {
    private Map<String, Long> mapa;

    public Acumulador() {
        this.mapa = new HashMap<>();
    }

    /**
     * Acumula el valor con el valor existente en la misma clave dada.
     * @param clave La clave en la que se acumulará el valor.
     * @param valor El valor a acumular.
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
        return mapa.get(clave);
    }
}