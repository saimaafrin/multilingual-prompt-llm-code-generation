import java.util.HashSet;
import java.util.Set;

public class CustomSet {
    private Set<Integer> set;

    public CustomSet() {
        this.set = new HashSet<>();
    }

    /** 
     * सेट से एक मान को हटाता है। यदि सेट में निर्दिष्ट तत्व था, तो true लौटाता है। 
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    // Optional: Method to add elements to the set for testing
    public void add(int val) {
        set.add(val);
    }

    public static void main(String[] args) {
        CustomSet customSet = new CustomSet();
        customSet.add(10);
        customSet.add(20);
        System.out.println(customSet.remove(10)); // true
        System.out.println(customSet.remove(30)); // false
    }
}