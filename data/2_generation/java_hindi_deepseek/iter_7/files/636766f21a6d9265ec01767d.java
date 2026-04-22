/**
 * ऑब्जेक्ट को स्ट्रिंग में बदलें, जब ऑब्जेक्ट null हो तो null लौटाएं, अन्यथा toString() लौटाएं;
 */
public static String toString(Object object) {
    if (object == null) {
        return null;
    }
    return object.toString();
}