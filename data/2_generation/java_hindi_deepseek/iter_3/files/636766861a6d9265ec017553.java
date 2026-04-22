import java.util.HashSet;
import java.util.Set;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
        // Initialize with some template variables for demonstration
        this.templateVariables.add("var1");
        this.templateVariables.add("var2");
        this.templateVariables.add("var3");
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
        Template template = new Template();
        System.out.println(template.isTemplateVariablePresent("var1")); // true
        System.out.println(template.isTemplateVariablePresent("var4")); // false
    }
}