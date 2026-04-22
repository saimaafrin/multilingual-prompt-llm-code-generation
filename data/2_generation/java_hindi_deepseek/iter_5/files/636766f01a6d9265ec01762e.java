/**
 * <p>जांचता है कि क्या प्राइमिटिव डबल्स का एक एरे खाली है या <code>null</code> है।</p>
 * @param array  परीक्षण के लिए एरे
 * @return <code>true</code> यदि एरे खाली है या <code>null</code> है
 * @since 2.1
 */
public static boolean isEmpty(final double[] array) {
    return array == null || array.length == 0;
}