import org.objectweb.asm.Label;

public class LabelManager {

    /** 
     * दिए गए बाइटकोड ऑफसेट के लिए संबंधित लेबल लौटाता है। इस विधि का डिफ़ॉल्ट कार्यान्वयन दिए गए ऑफसेट के लिए एक लेबल बनाता है यदि यह पहले से नहीं बनाया गया है।
     * @param bytecodeOffset एक विधि में बाइटकोड ऑफसेट।
     * @param labels पहले से बनाए गए लेबल, जो उनके ऑफसेट द्वारा अनुक्रमित हैं। यदि bytecodeOffset के लिए एक लेबल पहले से मौजूद है, तो इस विधि को एक नया लेबल नहीं बनाना चाहिए। अन्यथा, इसे इस ऐरे में नया लेबल संग्रहीत करना चाहिए।
     * @return एक नॉन-नल लेबल, जो labels[bytecodeOffset] के बराबर होना चाहिए।
     */
    protected Label readLabel(final int bytecodeOffset, final Label[] labels) {
        if (labels[bytecodeOffset] == null) {
            labels[bytecodeOffset] = new Label();
        }
        return labels[bytecodeOffset];
    }
}