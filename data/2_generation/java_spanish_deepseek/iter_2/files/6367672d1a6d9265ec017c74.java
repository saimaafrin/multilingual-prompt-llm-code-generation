import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        set = new HashSet<>();
    }

    /**
     * Elimina un valor del conjunto. Devuelve verdadero si el conjunto contenía el elemento especificado.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }
}