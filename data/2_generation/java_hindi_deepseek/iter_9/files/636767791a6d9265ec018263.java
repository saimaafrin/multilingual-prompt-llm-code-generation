import java.util.Objects;

/**
 * दिए गए क्लास नाम के अनुसार क्लास खोजें।
 * @param className क्लास नाम, यह null नहीं हो सकता।
 * @return क्लास, यह null नहीं होगा।
 * @throws ClassNotFoundException यदि क्लास नहीं मिलती है तो यह फेंका जाएगा।
 */
private Class<?> findClass(final String className) throws ClassNotFoundException {
    Objects.requireNonNull(className, "क्लास नाम null नहीं हो सकता");
    return Class.forName(className);
}