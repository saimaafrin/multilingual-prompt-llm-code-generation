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
     * Ascertain if a template variable is a member of this template.
     * @param name name The template variable.
     * @return true if the template variable is a member of the template, otherwise false.
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