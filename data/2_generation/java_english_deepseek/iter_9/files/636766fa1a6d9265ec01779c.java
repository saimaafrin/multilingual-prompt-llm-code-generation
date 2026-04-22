import java.util.Arrays;

private String parseToken(final char[] terminators) {
    StringBuilder token = new StringBuilder();
    int ch;
    while ((ch = System.in.read()) != -1) {
        char currentChar = (char) ch;
        if (Arrays.binarySearch(terminators, currentChar) >= 0) {
            break;
        }
        token.append(currentChar);
    }
    return token.toString();
}