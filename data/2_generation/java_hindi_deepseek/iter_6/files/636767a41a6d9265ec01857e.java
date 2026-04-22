/**
 * निर्दिष्ट {@code long} मानों की तुलना करता है। लौटाए गए मान का संकेत {@code ((Long) a).compareTo(b)} के समान है। <p> <b>Java 7 और बाद के लिए नोट:</b> इस विधि को अप्रचलित माना जाना चाहिए; इसके बजाय समकक्ष {@link Long#compare} विधि का उपयोग करें।
 * @param a तुलना के लिए पहला {@code long}
 * @param b तुलना के लिए दूसरा {@code long}
 * @return यदि {@code a} {@code b} से कम है तो नकारात्मक मान; यदि {@code a} {@code b} से अधिक है तो सकारात्मक मान; या यदि वे समान हैं तो शून्य
 */
private static int compareSigned(long a, long b) {
    return Long.compare(a, b);
}