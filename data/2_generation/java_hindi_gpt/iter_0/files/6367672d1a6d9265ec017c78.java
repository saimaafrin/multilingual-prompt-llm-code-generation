import java.util.HashSet;

public class CustomSet {
    private HashSet<Integer> set;

    public CustomSet() {
        set = new HashSet<>();
    }

    /** 
     * सेट में एक मान डालता है। यदि सेट में पहले से निर्दिष्ट तत्व नहीं था, तो सत्य लौटाता है। 
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    public static void main(String[] args) {
        CustomSet customSet = new CustomSet();
        System.out.println(customSet.insert(5)); // true
        System.out.println(customSet.insert(5)); // false
    }
}