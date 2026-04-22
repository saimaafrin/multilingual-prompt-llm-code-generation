import java.util.Objects;

public class ClassFinder {

    /**
     * 根据类名查找类。
     * @param className 类名，不能为空。
     * @return 类，不会空。
     * @throws ClassNotFoundException 如果找不到类则抛出此异常。
     */
    private Class findClass(final String className) throws ClassNotFoundException {
        Objects.requireNonNull(className, "className cannot be null");
        
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Could not find class: " + className, e);
        }
    }
}