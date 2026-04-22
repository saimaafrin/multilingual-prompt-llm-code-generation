import java.util.ArrayList;
import java.util.List;

public class ConstructorTracker {
    private List<AbstractType> constructorTypes;
    
    public ConstructorTracker() {
        constructorTypes = new ArrayList<>();
    }

    /**
     * Adds an abstract type to the list of types on which a constructor is invoked in the basic block.
     * @param abstractType an abstract type on a which a constructor is invoked.
     */
    public void addConstructorType(AbstractType abstractType) {
        if (abstractType != null) {
            constructorTypes.add(abstractType);
        }
    }
}

// Abstract type class for demonstration
abstract class AbstractType {
    private String typeName;
    
    public AbstractType(String typeName) {
        this.typeName = typeName;
    }
    
    public String getTypeName() {
        return typeName;
    }
}