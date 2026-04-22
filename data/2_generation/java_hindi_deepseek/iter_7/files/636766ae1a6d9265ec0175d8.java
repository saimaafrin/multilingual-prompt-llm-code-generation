import java.util.Objects;

/**
 * 'Content-Range' HTTP हेडर मान बनाएं।
 * @return 'Content-Range' मान
 */
private String buildContentRange() {
    // यहां हम एक उदाहरण के रूप में 0-999/1000 रेंज दिखा रहे हैं।
    // आप इसे अपनी आवश्यकतानुसार संशोधित कर सकते हैं।
    long start = 0;
    long end = 999;
    long total = 1000;

    // 'Content-Range' हेडर का फॉर्मेट: bytes start-end/total
    return String.format("bytes %d-%d/%d", start, end, total);
}