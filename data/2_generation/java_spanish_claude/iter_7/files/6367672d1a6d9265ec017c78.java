import java.util.HashSet;

public class IntegerSet {
    private HashSet<Integer> set;
    
    public IntegerSet() {
        set = new HashSet<>();
    }

    /**
     * Inserta un valor en el conjunto. Devuelve verdadero si el conjunto no contenía ya el elemento especificado.
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}