import java.util.HashSet;

public class CustomSet {
    private HashSet<Integer> set;

    public CustomSet() {
        set = new HashSet<>();
    }

    /**
     * सेट से एक मान को हटाता है। यदि सेट में निर्दिष्ट तत्व था, तो true लौटाता है। 
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    public void add(int val) {
        set.add(val);
    }

    public boolean contains(int val) {
        return set.contains(val);
    }

    public static void main(String[] args) {
        CustomSet customSet = new CustomSet();
        customSet.add(1);
        customSet.add(2);
        System.out.println(customSet.remove(1)); // true
        System.out.println(customSet.remove(3)); // false
    }
}