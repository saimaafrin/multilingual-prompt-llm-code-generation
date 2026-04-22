/**
 * @param timestamp        वर्तमान समय का टाइमस्टैम्प
 * @param expiredThreshold पिछले अपडेट समय और कैश से हटाए जाने वाले समय बिंदु के बीच की अवधि को दर्शाता है।
 * @return true का मतलब है कि इस मेट्रिक को कैश से हटाया जाना चाहिए।
 */
public boolean isExpired(long timestamp, long expiredThreshold) {
    long currentTime = System.currentTimeMillis();
    return (currentTime - timestamp) > expiredThreshold;
}