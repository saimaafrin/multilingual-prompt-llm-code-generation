import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * Elimina un valor del conjunto. Devuelve verdadero si el conjunto contenía el elemento especificado.
     * @param val El valor a eliminar del conjunto.
     * @return Verdadero si el conjunto contenía el elemento, falso en caso contrario.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }
}