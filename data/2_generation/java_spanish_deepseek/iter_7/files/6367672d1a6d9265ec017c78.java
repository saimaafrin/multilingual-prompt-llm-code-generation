import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * Inserta un valor en el conjunto. Devuelve verdadero si el conjunto no contenía ya el elemento especificado.
     * @param val El valor a insertar en el conjunto.
     * @return true si el valor no estaba presente en el conjunto, false en caso contrario.
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}