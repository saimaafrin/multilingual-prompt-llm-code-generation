import java.util.ArrayList;
import java.util.List;

public class TypeInitializer {
    // List to store initialized abstract types
    private List<Integer> initializedTypes;
    
    public TypeInitializer() {
        initializedTypes = new ArrayList<>();
    }

    /**
     * Adds an abstract type to the list of types on which a constructor is invoked in the basic block.
     * @param abstractType an abstract type on a which a constructor is invoked.
     */
    private void addInitializedType(final int abstractType) {
        if (!initializedTypes.contains(abstractType)) {
            initializedTypes.add(abstractType);
        }
    }
}