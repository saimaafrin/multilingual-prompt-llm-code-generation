import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /**
     * 解析 {@code typeVariable} 的第一个边界，如果无法解析则返回 {@code Unknown.class}。
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0) {
            return bounds[0];
        } else {
            return Unknown.class;
        }
    }

    public static class Unknown {
        // Placeholder class for unknown type
    }

    public static void main(String[] args) {
        // Example usage
        TypeVariable<?> typeVariable = ExampleClass.class.getTypeParameters()[0];
        Type bound = resolveBound(typeVariable);
        System.out.println("Resolved bound: " + bound);
    }

    public static class ExampleClass<T extends String> {
        // Example class with a type parameter
    }
}