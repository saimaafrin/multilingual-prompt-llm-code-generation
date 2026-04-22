import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /**
     * सेट में एक मान डालता है। यदि सेट में पहले से निर्दिष्ट तत्व नहीं था, तो सत्य लौटाता है।
     * 
     * @param val वह मान जिसे सेट में डाला जाना है।
     * @return true यदि मान सेट में नया था, अन्यथा false।
     */
    public boolean insert(int val) {
        return set.add(val);
    }
}