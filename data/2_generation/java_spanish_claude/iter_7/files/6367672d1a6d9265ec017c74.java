import java.util.HashSet;

public class IntSet {
    private HashSet<Integer> set;
    
    public IntSet() {
        set = new HashSet<>();
    }

    /**
     * Elimina un valor del conjunto. Devuelve verdadero si el conjunto contenía el elemento especificado.
     */
    public boolean remove(int val) {
        return set.remove(Integer.valueOf(val));
    }
}