import java.util.HashSet;
import java.util.Set;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
        // Example initialization, you can add more variables as needed
        this.templateVariables.add("var1");
        this.templateVariables.add("var2");
        this.templateVariables.add("var3");
    }

    /**
     * Ascertain if a template variable is a member of this template.
     * @param name The template variable.
     * @return true if the template variable is a member of the template, otherwise false.
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