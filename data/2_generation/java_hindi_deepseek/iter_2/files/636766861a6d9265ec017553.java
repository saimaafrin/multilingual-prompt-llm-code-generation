import java.util.HashSet;
import java.util.Set;

public class TemplateChecker {
    private Set<String> templateVariables;

    public TemplateChecker() {
        templateVariables = new HashSet<>();
        // Initialize with some template variables for demonstration
        templateVariables.add("var1");
        templateVariables.add("var2");
        templateVariables.add("var3");
    }

    /**
     * यह सुनिश्चित करें कि एक टेम्पलेट वेरिएबल इस टेम्पलेट का सदस्य है या नहीं।
     * @param name नाम टेम्पलेट वेरिएबल।
     * @return यदि टेम्पलेट वेरिएबल टेम्पलेट का सदस्य है, तो true, अन्यथा false।
     */
    public final boolean isTemplateVariablePresent(String name) {
        return templateVariables.contains(name);
    }

    public static void main(String[] args) {
        TemplateChecker checker = new TemplateChecker();
        System.out.println(checker.isTemplateVariablePresent("var1")); // true
        System.out.println(checker.isTemplateVariablePresent("var4")); // false
    }
}