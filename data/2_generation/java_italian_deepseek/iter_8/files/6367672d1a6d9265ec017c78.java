import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * Inserisce un valore nel "set". Restituisce true se il "set" non conteneva già l'elemento specificato.
     * @param val Il valore da inserire nel set.
     * @return true se l'elemento non era già presente, false altrimenti.
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}