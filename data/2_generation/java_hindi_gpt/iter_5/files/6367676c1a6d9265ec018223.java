import java.util.Collection;

public class CollectionUtils {
    /** 
     * जांचें कि दी गई संग्रह में दी गई तत्व उदाहरण मौजूद है या नहीं। <p>सुनिश्चित करता है कि दी गई उदाहरण मौजूद है, न कि समान तत्व के लिए <code>true</code> लौटाने के लिए।
     * @param collection जांचने के लिए संग्रह
     * @param element खोजने के लिए तत्व
     * @return <code>true</code> यदि पाया गया, <code>false</code> अन्यथा
     */
    public static boolean containsInstance(Collection<?> collection, Object element) {
        for (Object obj : collection) {
            if (obj == element) {
                return true;
            }
        }
        return false;
    }
}