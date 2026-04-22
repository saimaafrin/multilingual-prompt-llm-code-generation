import java.util.ArrayList;
import java.util.List;

public class TypeInitializer {
    // List to store initialized abstract types
    private List<Integer> initializedTypes;

    public TypeInitializer() {
        initializedTypes = new ArrayList<>();
    }

    /**
     * Aggiunge un tipo astratto alla lista dei tipi su cui viene invocato un costruttore nel blocco di base.
     * @param abstractType un tipo astratto su cui viene invocato un costruttore.
     */
    private void addInitializedType(final int abstractType) {
        if (!initializedTypes.contains(abstractType)) {
            initializedTypes.add(abstractType);
        }
    }
}