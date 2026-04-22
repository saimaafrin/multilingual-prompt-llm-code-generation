import java.util.ArrayList;
import java.util.List;

public class ConstructorInitialization {

    private List<Integer> initializedTypes;

    public ConstructorInitialization() {
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

    // Optional: Getter method to access the initialized types
    public List<Integer> getInitializedTypes() {
        return initializedTypes;
    }
}