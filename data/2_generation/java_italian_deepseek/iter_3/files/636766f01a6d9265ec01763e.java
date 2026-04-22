import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

private static String javaCharset(String charset) {
    try {
        // Mappa i nomi MIME ai nomi di set di caratteri Java
        switch (charset.toLowerCase()) {
            case "us-ascii":
                return "US-ASCII";
            case "iso-8859-1":
                return "ISO-8859-1";
            case "utf-8":
                return "UTF-8";
            case "utf-16":
                return "UTF-16";
            case "utf-16be":
                return "UTF-16BE";
            case "utf-16le":
                return "UTF-16LE";
            case "windows-1252":
                return "windows-1252";
            default:
                // Prova a ottenere il set di caratteri direttamente
                return Charset.forName(charset).name();
        }
    } catch (UnsupportedCharsetException e) {
        // Se il set di caratteri non è supportato, restituisci UTF-8 come fallback
        return "UTF-8";
    }
}