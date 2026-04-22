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
}