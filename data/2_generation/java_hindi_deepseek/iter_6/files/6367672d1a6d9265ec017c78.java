import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        set = new HashSet<>();
    }

    /**
     * सेट में एक मान डालता है। यदि सेट में पहले से निर्दिष्ट तत्व नहीं था, तो सत्य लौटाता है।
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}