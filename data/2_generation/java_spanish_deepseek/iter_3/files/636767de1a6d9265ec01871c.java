import java.util.HashMap;
import java.util.Map;

public class Acumulador {
    private Map<String, Long> mapa;

    public Acumulador() {
        this.mapa = new HashMap<>();
    }

    /**
     * Acumula el valor con el valor existente en la misma clave dada.
     * Si la clave no existe, se crea una nueva entrada con el valor proporcionado.
     * 
     * @param clave La clave en la que se acumulará el valor.
     * @param valor El valor a acumular.
     */
    public void acumulacionDeValor(String clave, Long valor) {
        mapa.put(clave, mapa.getOrDefault(clave, 0L) + valor);
    }

    // Método para obtener el valor acumulado de una clave específica
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