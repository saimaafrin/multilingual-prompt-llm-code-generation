import java.util.regex.Matcher;
import java.util.regex.Pattern;

private String unescapeId(String input) {
    if (input == null) {
        return null;
    }
    
    // Patrón para identificar secuencias de escape en identificadores DOT
    Pattern pattern = Pattern.compile("\\\\(.)");
    Matcher matcher = pattern.matcher(input);
    
    // Reemplazar las secuencias de escape con el carácter correspondiente
    StringBuffer result = new StringBuffer();
    while (matcher.find()) {
        matcher.appendReplacement(result, matcher.group(1));
    }
    matcher.appendTail(result);
    
    return result.toString();
}