import java.io.File;

/**
 * यदि निर्दिष्ट फ़ाइल मौजूद है, तो उसे हटाएं
 */
protected static void deleteFile(String fileName) {
    File file = new File(fileName);
    if (file.exists()) {
        if (file.delete()) {
            System.out.println("फ़ाइल सफलतापूर्वक हटाई गई: " + fileName);
        } else {
            System.out.println("फ़ाइल हटाने में विफल: " + fileName);
        }
    } else {
        System.out.println("फ़ाइल मौजूद नहीं है: " + fileName);
    }
}