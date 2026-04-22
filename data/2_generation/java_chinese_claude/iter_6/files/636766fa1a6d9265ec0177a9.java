import java.util.HashSet;
import java.util.Set;

public class TypeInitializer {
    // Set to store initialized abstract types
    private Set<Integer> initializedTypes;
    
    public TypeInitializer() {
        initializedTypes = new HashSet<>();
    }

    /**
     * 将一个抽象类型添加到基本块中调用构造函数的类型列表中。
     * @param abstractType 一个调用了构造函数的抽象类型。
     */
    private void addInitializedType(final int abstractType) {
        if (abstractType < 0) {
            throw new IllegalArgumentException("Abstract type must be non-negative");
        }
        initializedTypes.add(abstractType);
    }
}