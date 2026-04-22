public static Boolean[] toObject(final boolean[] array) {
    if (array == null) {
        return null;
    }
    Boolean[] result = new Boolean[array.length];
    for (int i = 0; i < array.length; i++) {
        result[i] = array[i];
    }
    return result;
}