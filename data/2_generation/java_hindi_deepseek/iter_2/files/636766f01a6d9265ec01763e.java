import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

private static String javaCharset(String charset) {
    switch (charset.toLowerCase()) {
        case "us-ascii":
            return StandardCharsets.US_ASCII.name();
        case "iso-8859-1":
            return StandardCharsets.ISO_8859_1.name();
        case "utf-8":
            return StandardCharsets.UTF_8.name();
        case "utf-16":
            return StandardCharsets.UTF_16.name();
        case "utf-16be":
            return StandardCharsets.UTF_16BE.name();
        case "utf-16le":
            return StandardCharsets.UTF_16LE.name();
        default:
            // यदि कोई मानक मिलान नहीं होता है, तो मूल वर्ण सेट लौटाएं
            return charset;
    }
}