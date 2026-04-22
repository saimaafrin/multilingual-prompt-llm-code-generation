import java.util.HashSet;
import java.util.Set;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
    }

    public void addTemplateVariable(String name) {
        this.templateVariables.add(name);
    }

    /**
     * Ascertain if a template variable is a member of this template.
     * @param name The template variable.
     * @return true if the template variable is a member of the template, otherwise false.
     */
    public final boolean isTemplateVariablePresent(String name) {
        return this.templateVariables.contains(name);
    }

    public static void main(String[] args) {
        Template template = new Template();
        template.addTemplateVariable("var1");
        template.addTemplateVariable("var2");

        System.out.println(template.isTemplateVariablePresent("var1")); // true
        System.out.println(template.isTemplateVariablePresent("var3")); // false
    }
}