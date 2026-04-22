import java.util.ArrayList;
import java.util.List;

public class BasicBlock {
    private List<Integer> initializedTypes;

    public BasicBlock() {
        this.initializedTypes = new ArrayList<>();
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

    // Optional: Getter method to access the list of initialized types
    public List<Integer> getInitializedTypes() {
        return initializedTypes;
    }
}