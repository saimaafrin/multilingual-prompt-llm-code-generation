import java.util.function.Supplier;

public class UniqueStringSupplier {

    /**
     * एक स्ट्रिंग सप्लायर बनाएं जो अद्वितीय स्ट्रिंग्स लौटाता है। लौटाए गए स्ट्रिंग्स बस प्रारंभ से शुरू होने वाले पूर्णांक हैं।
     * @param start अनुक्रम कहाँ से शुरू करना है
     * @return एक स्ट्रिंग सप्लायर
     */
    @SuppressWarnings("unchecked")
    public static Supplier<String> createStringSupplier(int start) {
        final int[] current = {start}; // Using an array to allow modification in the lambda

        return () -> String.valueOf(current[0]++);
    }

    public static void main(String[] args) {
        Supplier<String> stringSupplier = createStringSupplier(1);
        
        // Testing the supplier
        System.out.println(stringSupplier.get()); // Output: 1
        System.out.println(stringSupplier.get()); // Output: 2
        System.out.println(stringSupplier.get()); // Output: 3
    }
}