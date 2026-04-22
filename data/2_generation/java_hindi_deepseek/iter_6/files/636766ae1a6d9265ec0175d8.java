/**
 * 'Content-Range' HTTP हेडर मान बनाएं।
 * @return 'Content-Range' मान
 */
private String buildContentRange() {
    // यहां हम एक सरल उदाहरण के रूप में 0-999/1000 रेंज दिखा रहे हैं।
    // आप इसे अपनी आवश्यकतानुसार संशोधित कर सकते हैं।
    int start = 0;
    int end = 999;
    int total = 1000;
    
    return String.format("bytes %d-%d/%d", start, end, total);
}