import java.util.HashSet;

public class MySet {
    private HashSet<Integer> set;

    public MySet() {
        set = new HashSet<>();
    }

    /** 
     * सेट में एक मान डालता है। यदि सेट में पहले से निर्दिष्ट तत्व नहीं था, तो सत्य लौटाता है। 
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    public static void main(String[] args) {
        MySet mySet = new MySet();
        System.out.println(mySet.insert(5)); // true
        System.out.println(mySet.insert(5)); // false
    }
}