import java.util.HashSet;
import java.util.Set;

public class TypeManager {
    private Set<Integer> initializedTypes;

    public TypeManager() {
        initializedTypes = new HashSet<>();
    }

    /** 
     * Adds an abstract type to the list of types on which a constructor is invoked in the basic block.
     * @param abstractType an abstract type on a which a constructor is invoked.
     */
    private void addInitializedType(final int abstractType) {
        initializedTypes.add(abstractType);
    }

    public Set<Integer> getInitializedTypes() {
        return initializedTypes;
    }

    public static void main(String[] args) {
        TypeManager manager = new TypeManager();
        manager.addInitializedType(1);
        manager.addInitializedType(2);
        System.out.println(manager.getInitializedTypes());
    }
}