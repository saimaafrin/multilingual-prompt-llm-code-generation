import java.lang.Class;
import java.lang.ClassNotFoundException;

/**
 * दिए गए क्लास नाम के अनुसार क्लास खोजें।
 * @param className क्लास नाम, यह null नहीं हो सकता।
 * @return क्लास, यह null नहीं होगा।
 * @throws ClassNotFoundException यदि क्लास नहीं मिलती है तो यह फेंका जाएगा।
 */
private Class<?> findClass(final String className) throws ClassNotFoundException {
    if (className == null) {
        throw new IllegalArgumentException("Class name cannot be null");
    }
    return Class.forName(className);
}