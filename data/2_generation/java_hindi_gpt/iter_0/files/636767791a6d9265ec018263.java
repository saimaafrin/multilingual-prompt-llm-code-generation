public class ClassFinder {
    
    /** 
     * दिए गए क्लास नाम के अनुसार क्लास खोजें।
     * @param className क्लास नाम, यह null नहीं हो सकता।
     * @return क्लास, यह null नहीं होगा।
     * @throws ClassNotFoundException यदि क्लास नहीं मिलती है तो यह फेंका जाएगा।
     */
    private Class<?> findClass(final String className) throws ClassNotFoundException {
        if (className == null) {
            throw new IllegalArgumentException("className cannot be null");
        }
        return Class.forName(className);
    }
    
    public static void main(String[] args) {
        ClassFinder finder = new ClassFinder();
        try {
            Class<?> clazz = finder.findClass("java.lang.String");
            System.out.println("Class found: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
}