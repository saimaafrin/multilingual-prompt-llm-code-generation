/**
 * यह निर्धारित करें कि क्या एक पैरामीटर नाम वर्तमान स्थिति पर समाप्त होता है, अर्थात्, क्या दिया गया वर्ण एक विभाजक के रूप में योग्य है।
 */
private static boolean isParameterSeparator(final char c) {
    // विभाजक वर्णों की सूची
    final String separators = " ,;(){}[]<>+-*/%=&|^~!?:.\t\n\r";

    // जाँचें कि दिया गया वर्ण विभाजक सूची में है या नहीं
    return separators.indexOf(c) != -1;
}