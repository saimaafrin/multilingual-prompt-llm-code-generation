import java.util.HashSet;

public class IntegerSet {
    private HashSet<Integer> set;

    public IntegerSet() {
        set = new HashSet<>();
    }

    /**
     * Inserisce un valore nel "set". Restituisce true se il "set" non conteneva già l'elemento specificato.
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}