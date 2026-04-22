import java.util.HashSet;
import java.util.Set;

public class MySet {
    private Set<Integer> set;

    public MySet() {
        set = new HashSet<>();
    }

    /**
     * Elimina un valor del conjunto. Devuelve verdadero si el conjunto contenía el elemento especificado.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }
}