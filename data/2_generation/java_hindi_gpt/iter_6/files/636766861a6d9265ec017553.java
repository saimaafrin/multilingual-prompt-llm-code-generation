import java.util.HashSet;
import java.util.Set;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
    }

    public void addTemplateVariable(String name) {
        templateVariables.add(name);
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
        template.addTemplateVariable("variable1");
        System.out.println(template.isTemplateVariablePresent("variable1")); // true
        System.out.println(template.isTemplateVariablePresent("variable2")); // false
    }
}