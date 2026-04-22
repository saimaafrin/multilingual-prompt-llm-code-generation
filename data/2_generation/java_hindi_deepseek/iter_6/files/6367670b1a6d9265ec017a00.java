/**
 * <p>जांचता है कि क्या दो ऐरे की लंबाई समान है, <code>null</code> ऐरे को लंबाई <code>0</code> के रूप में मानते हुए।</p>
 * @param array1 पहला ऐरे, <code>null</code> हो सकता है
 * @param array2 दूसरा ऐरे, <code>null</code> हो सकता है
 * @return <code>true</code> यदि ऐरे की लंबाई मेल खाती है, <code>null</code> को एक खाली ऐरे के रूप में मानते हुए
 */
public static boolean isSameLength(final byte[] array1, final byte[] array2) {
    int length1 = (array1 == null) ? 0 : array1.length;
    int length2 = (array2 == null) ? 0 : array2.length;
    return length1 == length2;
}