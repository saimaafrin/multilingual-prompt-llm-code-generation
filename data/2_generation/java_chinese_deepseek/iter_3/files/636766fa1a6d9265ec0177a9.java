import java.util.ArrayList;
import java.util.List;

public class BasicBlock {
    private List<Integer> initializedTypes;

    public BasicBlock() {
        this.initializedTypes = new ArrayList<>();
    }

    /**
     * 将一个抽象类型添加到基本块中调用构造函数的类型列表中。
     * @param abstractType 一个调用了构造函数的抽象类型。
     */
    private void addInitializedType(final int abstractType) {
        if (!initializedTypes.contains(abstractType)) {
            initializedTypes.add(abstractType);
        }
    }

    // 其他方法...
}