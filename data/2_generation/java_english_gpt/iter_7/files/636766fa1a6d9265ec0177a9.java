import java.util.ArrayList;
import java.util.List;

public class TypeManager {
    private List<Integer> initializedTypes;

    public TypeManager() {
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

    public List<Integer> getInitializedTypes() {
        return initializedTypes;
    }

    public static void main(String[] args) {
        TypeManager manager = new TypeManager();
        manager.addInitializedType(1);
        manager.addInitializedType(2);
        manager.addInitializedType(1); // Duplicate, should not be added

        System.out.println(manager.getInitializedTypes()); // Output: [1, 2]
    }
}