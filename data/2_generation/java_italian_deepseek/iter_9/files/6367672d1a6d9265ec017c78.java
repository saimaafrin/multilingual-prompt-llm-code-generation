import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * Inserisce un valore nel "set". Restituisce true se il "set" non conteneva già l'elemento specificato.
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}