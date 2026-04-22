public static final <V> void reverse(V[] arr, int from, int to) {
    if (arr == null || from < 0 || to >= arr.length || from > to) {
        throw new IllegalArgumentException("Invalid input parameters");
    }

    while (from < to) {
        V temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
        from++;
        to--;
    }
}