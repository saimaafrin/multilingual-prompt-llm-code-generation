import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {

    /**
     * जांचें कि दी गई संग्रह में दी गई तत्व उदाहरण मौजूद है या नहीं। <p>सुनिश्चित करता है कि दी गई उदाहरण मौजूद है, न कि समान तत्व के लिए <code>true</code> लौटाने के लिए।
     * @param collection जांचने के लिए संग्रह
     * @param element खोजने के लिए तत्व
     * @return <code>true</code> यदि पाया गया, <code>false</code> अन्यथा
     */
    public static boolean containsInstance(Collection collection, Object element) {
        if (collection == null || element == null) {
            return false;
        }
        
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object current = iterator.next();
            if (current == element) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        Collection<String> collection = new java.util.ArrayList<>();
        collection.add("Hello");
        collection.add("World");

        String element = "Hello";
        System.out.println(containsInstance(collection, element)); // Should print true

        String newElement = new String("Hello");
        System.out.println(containsInstance(collection, newElement)); // Should print false
    }
}