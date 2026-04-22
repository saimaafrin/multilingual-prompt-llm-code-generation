public int nonZeros(int[] row) {
    int count = 0;
    for (int value : row) {
        if (value != 0) {
            count++;
        }
    }
    return count;
}