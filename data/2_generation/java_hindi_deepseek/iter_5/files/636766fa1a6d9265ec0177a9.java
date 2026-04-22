import java.util.ArrayList;
import java.util.List;

public class ConstructorInitializer {

    private List<Integer> initializedTypes;

    public ConstructorInitializer() {
        this.initializedTypes = new ArrayList<>();
    }

    /**
     * एक अमूर्त प्रकार को उन प्रकारों की सूची में जोड़ता है जिन पर एक कंस्ट्रक्टर मूलभूत ब्लॉक में लागू होता है।
     * @param abstractType एक अमूर्त प्रकार जिस पर एक कंस्ट्रक्टर लागू होता है।
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
        ConstructorInitializer initializer = new ConstructorInitializer();
        initializer.addInitializedType(1);
        initializer.addInitializedType(2);
        initializer.addInitializedType(1); // Duplicate, should not be added

        System.out.println(initializer.getInitializedTypes()); // Output: [1, 2]
    }
}